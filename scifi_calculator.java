
 import java.util.Scanner;

    public class scifi_calculator{
        public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            while(true){
            System.out.println("CASIO");
            System.out.println("1.Addition");
            System.out.println("2.Subtraction");
            System.out.println("3.Multiplication");
            System.out.println("4.Division");
            System.out.println("5.Exponential");
            System.out.println("6.Temperature conversion");
             System.out.println("7.Exit");

            System.out.print("Enter the number of operation:");
            int num=sc.nextInt();
        double no1=0,no2=0;
            double output=0;

            switch(num){
                case 1:
                System.out.print("Enter two numbers:");
                no1=sc.nextDouble();
                no2=sc.nextDouble();
                output=no1+no2;
                break;
            
                case 2:
                System.out.print("Enter two numbers:");
                no1=sc.nextDouble();
                no2=sc.nextDouble();
                output=no1-no2;
                break;
            
            
                case 3:
                System.out.print("Enter two numbers:");
                no1=sc.nextDouble();
                no2=sc.nextDouble();
                output=no1*no2;
                break;
            
        
                case 4:
                System.out.print("Enter two numbers:");
                no1=sc.nextDouble();
                no2=sc.nextDouble();
                if(no2!=0)
                output=no1/no2;
                else
                System.out.print("syntax error : cannot divide by zero");
                break;
            
            
                case 5:
                System.out.print("Enter two numbers:");
                no1=sc.nextDouble();
                no2=sc.nextDouble();
                output=Math.pow(no1,no2);
                break;    
            
                case 6:
                System.out.println("select type of conversion:");
                System.out.println("1.celsius to kelvin");
                System.out.println("2.Fahrenheit to kelvin");
                int type=sc.nextInt();
                if(type==1){
                    System.out.print("Enter celsius_number:");
            double number=sc.nextDouble();
                output=number+273;
                System.out.println("Temp in kelvin:"+output);
                }
                else if(type==2){
                    System.out.print("Enter fahrenheit_number:");
            double number=sc.nextDouble();
                output=((number-32)*5/9)+273;
                System.out.println("Temp in kelvin:"+output);
                }
                else{
                    System.out.println("invalid option choosen");
                    return;
                }
                break;
               
                case 7:
                System.out.println("Exiting..");
                break;

                default:
                System.out.println("invalid option selected");
            }
            if(num>=1 && num<=5){
                System.out.println("result :"+output);
            }
        }
            }
        }

