package EjercicioTaller1;
import java.util.Scanner;

public class EjercicioThread extends Thread{

	private int limSup;
	private String name;
	private long time;

	public EjercicioThread(String name, int limSup, long time) {

		this.name=name;
		this.limSup=limSup;
		this.time=time;
	}

	public void run() {
		try {
			
			int i = (name.equals("par"))?2:1;
			
			while (i <= limSup)
			{
				System.out.println(i);
				Thread.sleep(50);
				i+=2;
			}

		}
		catch(Exception e) {}
	}

	public static void main(String[] args) {

		Scanner lector = new Scanner(System.in);

		try
		{
			System.out.println("Por favor ingrese el límite superior: ");

			int limSup=Integer.parseInt(lector.nextLine().trim());

			System.out.println("Por favor ingrese los milisegundos que quiere dormir los thread: ");

			long time = Long.parseLong(lector.nextLine().trim());

			EjercicioThread t1 = new EjercicioThread("par",limSup,time);
			EjercicioThread t2 = new EjercicioThread("impar",limSup,time);


			t1.start();
			t2.start();
		}
		catch(NumberFormatException e)
		{
			System.out.println("Por favor ingrese un número válido");
		}


		lector.close();
	}

}
