import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Automata{
    static Scanner ent = new Scanner(System.in);
    public static void main(String[] args)throws IOException{
        int opc;
        String cadena;
        do{
            System.out.println("Selecciona una opcion:");
            System.out.println("1. AFD numero real");
            System.out.println("2. AFD detecta par de ceros y sin 1's sucesivos");
            System.out.println("3. AFD dos o mas simbolos consecutivos iguales para {a, b, c, d}");
            System.out.println("4. Automata libre");
            System.out.println("5. Salir");
            opc=ent.nextInt();
            switch(opc){
                case 1:
                    cadena=ent.next();
                    System.out.println(ValidarAutoUno(cadena));
                break;
                case 2:
                    cadena=ent.next();
                    System.out.println(ValidarAutoDos(cadena));
                break;
                case 3:
                    cadena=ent.next();
                    System.out.println(ValidarAutoTres(cadena));
                break;
                case 4:
                    File file = new File("laberinto.jpeg");
                    BufferedImage bufferedImage = ImageIO.read(file);
            
                    ImageIcon imageIcon = new ImageIcon(bufferedImage);
                    JFrame jFrame = new JFrame();
            
                    jFrame.setLayout(new FlowLayout());
                    
                    jFrame.setSize(1000, 621);
                    JLabel jLabel = new JLabel();
            
                    jLabel.setIcon(imageIcon);
                    jFrame.add(jLabel);
                    jFrame.setVisible(true);
                    
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    cadena=ent.next();
                    System.out.println(ValidarAutoCuatro(cadena));

                break;
                case 5:
                break;
                default:
                System.out.println("opcion invalida");
            }
        }while(opc!=5);
    }
    public static String ValidarAutoUno(String cadena){
        char estado;
        char []caracteres=cadena.toCharArray();
        estado='A';
        for(char caracter:caracteres){
            System.out.println("valor leido: "+caracter+"->"+"estado: "+estado);
            switch (estado){
                
                    
                case 'A':
                        switch(caracter){
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                            case '+':
                            case '-':     
                                estado='B';
                            break;
                            default:
                                estado='N';
                        }
                   break;
                 case 'B':
                        switch(caracter){
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':    
                                estado='B';
                            break;
                            case 'E':
                            case 'e':
                                estado='E';
                            break;
                            case '.':
                                estado='C';
                            break;
                            
                            default:
                                estado='N';
                        }
                    break;
                    case 'C':
                        switch(caracter){
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':    
                                estado='D';
                            break;
                            default:
                                estado='N';
                        }
                   break;
                   case 'D':
                        switch(caracter){
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':    
                                estado='D';
                            break;
                            case 'E':
                            case 'e':
                                estado='E';
                            break;
                            default:
                                estado='N';
                        }
                   break;
                   case 'E':
                        switch(caracter){
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':    
                                estado='G';
                            break;
                            case '+':
                            case '-':
                                estado='F';
                            break;
                            default:
                                estado='N';
                        }
                   break;
                   case 'F':
                        switch(caracter){
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':    
                                estado='G';
                            break;
                            default:
                                estado='N';
                        }
                   break;
                   case 'G':
                        switch(caracter){
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':    
                                estado='G';
                            break;
                            default:
                                estado='N';
                        }
                   break;
            }
            
        }  
        if(estado=='D'||estado=='G'||estado=='B')
            return "<----------cadena aceptada---------->";
        else 
            return "<----------cadena NO aceptada---------->";
               
    }
    
    
    public static String ValidarAutoDos(String entrada){
        char estado;
        char[ ] letras= entrada.toCharArray();
        estado='A';
        
        for(char letra: letras){
            System.out.println("valor leido: "+letra+"->"+"estado: "+estado);
             switch(estado){
                 case 'A':
                     
                     switch (letra){
                         case '0':
                             estado='B';
                             break;
                         case '1':
                             estado='D';
                             break;
                         default:
                             estado='F';  
                      }
                     break;
                 
                 case 'B':
                     switch (letra){
                         case '0':
                             estado='A';
                             break;
                         case '1':
                             estado='C';
                             break;
                         default:
                             estado='F';
     
                     }
                    break;
                     
                 case 'C':
                     switch (letra){
                         case '0':
                             estado='A';
                             break;
                         case '1':
                             estado='E';
                             break;
                         default:
                             estado='F';
                     }
                     break;
                     
                 case 'D':
                     switch (letra){
                         case '0':
                             estado='B';
                             break;
                         case '1':
                             estado='E';
                             break;
                         default:
                             estado='F';           
                      }
                    break;
                    
                 case 'E':
                     switch(letra){
                         case '0':
                         case '1':
                              estado='E';
                             break;
                         default:
                             estado='F';  
                      }    
                     break;
                     
                 case 'F':  //Estado fallido
                     break;
                 
                 }
                 
             }
            
            if (estado=='A'||estado=='D'){
                return "<----------cadena aceptada---------->";
            }else{
                return "<----------cadena NO aceptada---------->";
            }
          
       
    }


/**
 *
 * @author Angelito
 */
    
    
    public static String ValidarAutoTres(String entrada){
        char[ ] letras= entrada.toCharArray();
        char estado;
        estado='A';
        
         for(char letra: letras){
            System.out.println("valor leido: "+letra+"->"+"estado: "+estado);
             switch(estado){
                 
                 case 'A':
                     switch (letra){
                         case 'a':
                             estado='B';
                         break;
                         
                         case 'b':
                             estado='C';
                             break;

                         case 'c':
                             estado='D';
                             break;
                         case 'd':
                             estado='E';
                             break;
    
                         default:
                             estado='X';
                     }
                     break;
                     
                     case 'B':
                         switch(letra){
                             case 'a':
                                 estado='F';
                                 break;
                             case 'b':
                                 estado='C';
                                 break;
                             case 'c':
                                 estado='D';
                                 break;
                             case 'd':
                                 estado='E';
                                 break; 
                             default:
                                 estado='X';       
                         }
                     break;
                     
                     case 'C':
                         switch(letra){
                             case 'a':
                                 estado='B';
                                 break;
                             case 'b':
                                 estado='F';
                                 break;
                             case 'c':
                                 estado='D';
                                 break;
                             case 'd':
                                 estado='E';
                                 break;
                            
                             default:
                                 estado='X';
                         }
                     break;
                     
                     case 'D':
                         switch(letra){
                            case 'a':
                                 estado='B';
                                 break; 
                             case 'b':
                                 estado='C';
                                 break;
                              case 'c':
                                 estado='F';
                                 break;
                               case 'd':
                                 estado='E';
                                 break;  
                                 
                               default:
                                   estado='X';
                               
                         }
                     break;
                     
                     case 'E':
                         switch(letra){
                             case 'a':
                                 estado='B';
                                 break; 
                            case 'b':
                                 estado='C';
                                 break; 
                            case 'c':
                                 estado='D';
                                 break;    
                            case 'd':
                                 estado='F';
                                 break;  
                            default:
                                estado='X';
                         }
      
                     break;
                     
                     case 'F':
                        switch(letra){
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                                 estado='F';
                                 break; 
                            default:
                                estado='X';
                        } 
                         
                     break;
                     
                     case 'X':
                     break;
                 
             }
             
             
         }
         if (estado=='F'){
            return "<----------cadena aceptada---------->";
        }else{
            return "<----------cadena NO aceptada---------->";
        }
 
    }
    public static String ValidarAutoCuatro(String entrada){
        char[ ] letras= entrada.toCharArray();
        String estado;
        estado="e24";        
         for(char letra: letras){
            System.out.println("valor leido: "+letra+"->"+"estado: "+estado);
             switch(estado){
                 
                 case "e24":
                     switch (letra){
                         case 'a':
                             estado="e23";
                         break;
                         
                         case 's':
                             estado="e24";
                             break;

                         case 'd':
                             estado="e24";
                             break;
                         case 'w':
                             estado="e24";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e23":
                     switch (letra){
                         case 'a':
                             estado="e23";
                         break;
                         
                         case 's':
                             estado="e33";
                             break;

                         case 'd':
                             estado="e24";
                             break;
                         case 'w':
                             estado="e23";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e33":
                     switch (letra){
                         case 'a':
                             estado="e32";
                         break;
                         
                         case 's':
                             estado="e33";
                             break;

                         case 'd':
                             estado="e33";
                             break;
                         case 'w':
                             estado="e23";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e32":
                     switch (letra){
                         case 'a':
                             estado="e31";
                         break;
                         
                         case 's':
                             estado="e32";
                             break;

                         case 'd':
                             estado="e33";
                             break;
                         case 'w':
                             estado="e32";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e31":
                     switch (letra){
                         case 'a':
                             estado="e31";
                         break;
                         
                         case 's':
                             estado="e41";
                             break;

                         case 'd':
                             estado="e32";
                             break;
                         case 'w':
                             estado="e31";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e41":
                     switch (letra){
                         case 'a':
                             estado="e40";
                         break;
                         
                         case 's':
                             estado="e41";
                             break;

                         case 'd':
                             estado="e42";
                             break;
                         case 'w':
                             estado="e31";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e42":
                     switch (letra){
                         case 'a':
                             estado="e41";
                         break;
                         
                         case 's':
                             estado="e42";
                             break;

                         case 'd':
                             estado="e43";
                             break;
                         case 'w':
                             estado="e42";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e43":
                     switch (letra){
                         case 'a':
                             estado="e42";
                         break;
                         
                         case 's':
                             estado="e43";
                             break;

                         case 'd':
                             estado="e44";
                             break;
                         case 'w':
                             estado="e43";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e44":
                     switch (letra){
                         case 'a':
                             estado="e43";
                         break;
                         
                         case 's':
                             estado="e44";
                             break;

                         case 'd':
                             estado="e44";
                             break;
                         case 'w':
                             estado="e34";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e34":
                     switch (letra){
                         case 'a':
                             estado="e34";
                         break;
                         
                         case 's':
                             estado="e44";
                             break;

                         case 'd':
                             estado="e34";
                             break;
                         case 'w':
                             estado="e34";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e40":
                     switch (letra){
                         case 'a':
                             estado="e40";
                         break;
                         
                         case 's':
                             estado="e40";
                             break;

                         case 'd':
                             estado="e41";
                             break;
                         case 'w':
                             estado="e30";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e30":
                     switch (letra){
                         case 'a':
                             estado="e30";
                         break;
                         
                         case 's':
                             estado="e40";
                             break;

                         case 'd':
                             estado="e30";
                             break;
                         case 'w':
                             estado="e20";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e20":
                     switch (letra){
                         case 'a':
                             estado="e20";
                         break;
                         
                         case 's':
                             estado="e30";
                             break;

                         case 'd':
                             estado="e21";
                             break;
                         case 'w':
                             estado="e20";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e21":
                     switch (letra){
                         case 'a':
                             estado="e20";
                         break;
                         
                         case 's':
                             estado="e21";
                             break;

                         case 'd':
                             estado="e22";
                             break;
                         case 'w':
                             estado="e21";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e22":
                     switch (letra){
                         case 'a':
                             estado="e21";
                         break;
                         
                         case 's':
                             estado="e22";
                             break;

                         case 'd':
                             estado="e22";
                             break;
                         case 'w':
                             estado="e12";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e12":
                     switch (letra){
                         case 'a':
                             estado="e12";
                         break;
                         
                         case 's':
                             estado="e22";
                             break;

                         case 'd':
                             estado="e13";
                             break;
                         case 'w':
                             estado="e12";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e13":
                     switch (letra){
                         case 'a':
                             estado="e12";
                         break;
                         
                         case 's':
                             estado="e13";
                             break;

                         case 'd':
                             estado="e13";
                             break;
                         case 'w':
                             estado="e03";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e03":
                     switch (letra){
                         case 'a':
                             estado="e02";
                         break;
                         
                         case 's':
                             estado="e13";
                             break;

                         case 'd':
                             estado="e04";
                             break;
                         case 'w':
                             estado="e03";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e04":
                     switch (letra){
                         case 'a':
                             estado="e03";
                         break;
                         
                         case 's':
                             estado="e14";
                             break;

                         case 'd':
                             estado="e04";
                             break;
                         case 'w':
                             estado="e04";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e14":
                     switch (letra){
                         case 'a':
                             estado="e14";
                         break;
                         
                         case 's':
                             estado="e14";
                             break;

                         case 'd':
                             estado="e14";
                             break;
                         case 'w':
                             estado="e04";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e02":
                     switch (letra){
                         case 'a':
                             estado="e01";
                         break;
                         
                         case 's':
                             estado="e02";
                             break;

                         case 'd':
                             estado="e03";
                             break;
                         case 'w':
                             estado="e02";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e01":
                     switch (letra){
                         case 'a':
                             estado="e01";
                         break;
                         
                         case 's':
                             estado="e11";
                             break;

                         case 'd':
                             estado="e02";
                             break;
                         case 'w':
                             estado="e01";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e11":
                     switch (letra){
                         case 'a':
                             estado="e10";
                         break;
                         
                         case 's':
                             estado="e11";
                             break;

                         case 'd':
                             estado="e11";
                             break;
                         case 'w':
                             estado="e01";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e10":
                     switch (letra){
                         case 'a':
                             estado="e10";
                         break;
                         
                         case 's':
                             estado="e10";
                             break;

                         case 'd':
                             estado="e11";
                             break;
                         case 'w':
                             estado="e00";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                     case "e00":
                     switch (letra){
                         case 'a':
                             estado="e00";
                         break;
                         
                         case 's':
                             estado="e10";
                             break;

                         case 'd':
                             estado="e00";
                             break;
                         case 'w':
                             estado="e00";
                             break;
    
                         default:
                             estado="X";
                     }
                     break;
                 
             }
             
             
         }
         if (estado.equals("e00")){
            return "<----------Lograste sacar al burrito---------->";
        }else{
            return "<----------No lo lograste---------->";
        }
 
    }   



}