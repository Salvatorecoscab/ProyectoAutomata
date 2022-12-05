import java.util.Scanner;

public class Automata{
    static Scanner ent = new Scanner(System.in);
    public static void main(String[] args){
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
    



}