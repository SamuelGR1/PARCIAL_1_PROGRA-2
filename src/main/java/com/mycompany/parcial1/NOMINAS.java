/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial1;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class NOMINAS {

    static Scanner leer = new Scanner (System.in);
    private static String [][]nomina1 = new String [6][11];

   private static final int NOMBRE=0;
   private static final int ENERO=1;
   private static final int FEBRERO=2;
   private static final int MARZO=3;
   private static final int ABRIL=4;
   private static final int TOTAL_VENTAS=5;
   private static final int COMISION_X20=6;
   private static final int COMISION_X35=7;
   private static final int TOTAL_VENTA_COMISION=8;
   private static final int ISR=9;
   private static final int LIQUIDO=10;
   private static final int total=11;

    public static void main(String[] args){

      
       boolean salir = false;
       int opcion;

       do {
          System.out.println("\n####--BIENVENIDO--####\n");
          System.out.println("1. COMISIONES");
          System.out.println("2. lIQUIDO MAYOR 2");
          System.out.println("3. LIQUIDO MENOR 3");
          System.out.println("4. salir");

          System.out.println("\nINTODUCE UN NUMERO:");
          opcion = leer.nextInt();
          System.out.println("\n");
        

          switch(opcion){

              case 1:

                 System.out.println("\t\t\t\t\t\t\t\t---NOMINA DE TRABAJADORES Y COMISIONES---\n");
                 System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t   COMISIONES\t\t\t\t\tBONO\n");
                 System.out.println("NOMBRE\t\tENERO\t\tFEBRERO\t\tMARZO\t\tABRIL\t\tVENTA TOTAL\t20%\t\t35%"
                                 + "\t\tTOTAL\t\tISR 5%\t\tLIQUIDO");
                 System.out.println("____________________________________________________________________"
   + "____________________________________________________________________________________________________");
                 datosmatriz();
                 calculos();

                 columnas();
                 imprimedecora();
              break;

              case 2:

                  
                   mayor1();
                                  
               break;

               case 3:

                  
                   menor1();
                                  
               break;

              case 4:
               salir = true;
                System.out.println("has salido");
              break; 
             default:
               System.out.println("DATO INVALIDO");

            }

        }while (opcion!=4);
    }



      public static void datosmatriz(){
      //nombres
         nomina1[0][0]="Ruldin";
         nomina1[1][0]="Jairo";
         nomina1[2][0]="Andrew";
         nomina1[3][0]="Samuel";
         nomina1[4][0]="Jose";
         nomina1[5][0]="TOTAL";
      //venta enero
         nomina1[0][ENERO]="500";
         nomina1[1][ENERO]="250";
         nomina1[2][ENERO]="500";
         nomina1[3][ENERO]="240";
         nomina1[4][ENERO]="300";
      //venta febrero
         nomina1[0][FEBRERO]="540";
         nomina1[1][FEBRERO]="280";
         nomina1[2][FEBRERO]="650";
         nomina1[3][FEBRERO]="398";
         nomina1[4][FEBRERO]="320";
      //venta marzo
         nomina1[0][MARZO]="650";
         nomina1[1][MARZO]="360";
         nomina1[2][MARZO]="450";
         nomina1[3][MARZO]="300";
         nomina1[4][MARZO]="200";
      //venta abril
         nomina1[0][ABRIL]="460";
         nomina1[1][ABRIL]="400";
         nomina1[2][ABRIL]="500";
         nomina1[3][ABRIL]="330";
         nomina1[4][ABRIL]="150";
        }


       public static void imprimedecora(){

           for (int x=0; x < nomina1.length; x++) {
              System.out.print("|");

                  for (int y=0; y < nomina1[x].length; y++) {
                     System.out.print (nomina1[x][y]);

                     if (y!=nomina1[x].length-1) 
                         System.out.print("\t\t");
                    }

               System.out.println("|");
            }
        }

     private static void calculos(){
    
           int sumaventa;
           double totalcomiventa;
           double comision1;
           double totalcomi;
           double isr;
           double liquido;
           
           
                
           for (int i=0;i<5;i++){

               sumaventa= Integer.parseInt(nomina1[i][ENERO]);
               sumaventa= sumaventa + Integer.parseInt(nomina1[i][FEBRERO]);
               sumaventa= sumaventa + Integer.parseInt(nomina1[i][MARZO]);
               sumaventa= sumaventa + Integer.parseInt(nomina1[i][ABRIL]);
               nomina1[i][TOTAL_VENTAS]= sumaventa+"";

               

                if(sumaventa<=2000){
                     comision1=sumaventa*0.2;

                     totalcomi = Math.round(comision1*100.0)/100.0; 
                     nomina1[i][COMISION_X20]= String.valueOf(totalcomi);
                }
                else{
                  nomina1[i][COMISION_X20]="0";

                }

                if(sumaventa>=2001){
                    comision1=sumaventa*0.35;
                    totalcomi = Math.round(comision1*100.0)/100.0; 
                    nomina1[i][COMISION_X35]= String.valueOf(totalcomi);
                }
                else{
                   nomina1[i][COMISION_X35]="0";

                }

             double totalcomi20 = Double.parseDouble(nomina1[i][COMISION_X35]);
             double totalcomi35 = Double.parseDouble(nomina1[i][COMISION_X20]);
             totalcomiventa=sumaventa+totalcomi20+totalcomi35;
             nomina1[i][TOTAL_VENTA_COMISION]= totalcomiventa+"";

             //CALCULO ISR
             isr=totalcomiventa*0.05; 
             double totalisr = Math.round(isr*100.0)/100.0;
             nomina1[i][ISR]=totalisr+"";

             //CALCULO TOTAL LIQUIDO
             liquido=totalcomiventa-totalisr;
             nomina1[i][LIQUIDO]=liquido+"";

              
               
            }   
        }

       
       public static void columnas(){
              for (int i=1;i<11;i++){

              double columtotal=0;
              
                 columtotal=Double.parseDouble(nomina1[0][i]);
                 columtotal=columtotal+Double.parseDouble(nomina1[1][i]);
                 columtotal=columtotal+Double.parseDouble(nomina1[2][i]); 
                 columtotal=columtotal+Double.parseDouble(nomina1[3][i]);
                 columtotal=columtotal+Double.parseDouble(nomina1[4][i]);
               double colum = Math.round(columtotal*100.0)/100.0;
                 nomina1[5][i]= colum+"";

             }
              
         }
  
       public static void mayor1(){
        datosmatriz();
          calculos(); 
        

        double mayor=0, monto=0;
        String y="";
        for (int i = 0; i < 5; i++) {
            monto=Double.parseDouble(nomina1[i][LIQUIDO]);

            if (monto>mayor) {
                mayor=monto;
                y=nomina1[i][LIQUIDO-10];
            }
            else{
                monto=monto;

            }
        }

        System.out.println("Vendedor que recibe mas: " + y);
    }
    

      public static void menor1(){
         datosmatriz();
          calculos(); 

        double menor=0, monto=0;
        String y="";
        menor=Double.parseDouble(nomina1[0][LIQUIDO]);
        for (int i = 0; i < 5; i++) {
            monto=Double.parseDouble(nomina1[i][LIQUIDO]);

            if (monto<menor) {
                menor=monto;
                y=nomina1[i][LIQUIDO-10];
            }
            else{
                monto=menor;
            }
        }

        System.out.println("vendedor que menos recibe: " + y);
    }

}