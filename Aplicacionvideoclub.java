package videoclub;


import java.util.Vector;

import daw.com.Teclado;

public class Aplicacionvideoclub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



Vector<Cliente>datos;
Vector<Producto>datos1;
datos= new Vector<Cliente>();
datos1= new Vector<Producto>();

mostrarmenu(datos,datos1);


}
	public static void mostrarmenu (Vector <Cliente>datos,Vector <Producto>datos1){
		int menu=0;
		do{
			
			System.out.println("___    _______________          ______________       ______  ");
			System.out.println("__ |  / /__(_)_____  /____________  ____/__  /___  ___    /_");
			System.out.println("__ | / /__  /_  __  /_  _ )  __ )  /    __  /_  / / /_  __  )");
			System.out.println("__ |/ / _  / / /_/ / /  __/ /_/ / /___  _  / / /_/ /_  /_/ /");
			System.out.println("_____/  /_/ (__,_/   (___/(____/(____/  /_/  (__,_/ /_.___/");
			
			System.out.println("-------------------------------------------------------------");
			System.out.println("elige una opcion");
			System.out.println("1 listar productos sin alquilar");
			System.out.println("2 añadir un nuevo producto");
			System.out.println("3 mostrar ficha de producto");
			System.out.println("4 listar clientes");
			System.out.println("5 añadir cliente");
			System.out.println("6 mostrar ficha de cliente");
			System.out.println("7 alquilar producto");
			System.out.println("8 devolver producto");
			System.out.println("9 salir");
			System.out.println("--------------------------------------------------------------");
			menu=Teclado.leerInt("que quieres hacer?");
			
			switch (menu){
			 
			case 1:
				limpiar(46);
				mostrarAlquilados(datos1);
				Teclado.leerString("Presione cualquier tecla para volver al menu.");
				break;
			case 2: 
				limpiar(46);
				anadirp(datos1);
				Teclado.leerString("Presione cualquier tecla para volver al menu.");
				break;
			case 3:
				limpiar(46);
				mostrarp(datos1);
				Teclado.leerString("Presione cualquier tecla para volver al menu.");
				break;
			case 4:
				limpiar(46);
				mostrarListado(datos);
				Teclado.leerString("Presione cualquier tecla para volver al menu.");
				break;
			case 5:
				limpiar(46);
				anadirc(datos);
				Teclado.leerString("Presione cualquier tecla para volver al menu.");
				break;
			case 6:
				limpiar(46);
				mostrarc(datos);
				Teclado.leerString("Presione cualquier tecla para volver al menu.");
				break;
			case 7:
				limpiar(46);
				alquilarProducto (datos1,datos);
				Teclado.leerString("Presione cualquier tecla para volver al menu.");
				break;
			case 8:
				limpiar(46);
				devolverProducto(datos1,datos);
				Teclado.leerString("Presione cualquier tecla para volver al menu.");
				break;
			case 9:
				limpiar(46);
				System.out.println("------------------------------------------------------");
				System.out.println("gracias por utilizar este programa");
				System.out.println("------------------------------------------------------");
				break;
			default:
				System.out.println("opcion no valida");
				break;
			}
		}while(menu!=9);
	
	}
	public static void anadirc (Vector <Cliente>datos){
		Cliente cliente;
		String seguir;
		do{
			cliente= new Cliente();
			cliente.leerDatos();
			datos.addElement(cliente);
			seguir=Teclado.leerString("desea seguir s/n");
		}while(seguir.equals("s"));
	}
	public static void mostrarListado(Vector <Cliente>datos){
		Cliente cliente;
		for (int i =0;i<datos.size();i++) {
			cliente=datos.get(i);
			cliente.mostrarDatos();
			}
	}
	public static void mostrarc (Vector <Cliente>datos){
		Cliente cliente;
		boolean encontrado=false;
		int num=Teclado.leerInt("dime el numero de cliente a buscar");
		for (int i =0;i<datos.size() && encontrado==false;i++) {
			cliente=datos.get(i);
			if (datos.get(i).getNumerocliente()==num){
				encontrado=true;
				cliente.mostrarDatos();
				
			}
			cliente.mostrarDatos();
			}
	}
	public static void anadirp (Vector <Producto>datos1){
		String seguir;
		Producto producto;
		do{
			producto = new Producto();
			producto.leerDatos();
			datos1.addElement(producto);
			seguir=Teclado.leerString("desea seguir s/n");
		}while(seguir.equals("s"));
	}
	public static void mostrarp (Vector <Producto>datos1){
		boolean encontrado=false;
		Producto producto;
		String buscar=Teclado.leerString("dime el titulo del producto a buscar");
		System.out.println(buscar);
		for (int i =0;i<datos1.size() && encontrado==false;i++) {
			
			producto=datos1.get(i);
			
			if (datos1.get(i).getTitulo().equals(buscar)){
				encontrado=true;
				datos1.get(i).mostrarDatos();
				
			}
			}
	}
	public static void mostrarAlquilados(Vector <Producto>datos1){
		Producto producto;
		for (int i =0;i<datos1.size();i++){
			producto=datos1.get(i);
			if (datos1.get(i).getAlquilado()==false){
				producto.mostrarDatos();
			}else {
				System.out.println("todos los productos se encuentran alquilados");
			}
		}
	}
	public static void alquilarProducto (Vector <Producto>datos1,Vector <Cliente>datos){
		Producto producto;
		Cliente cliente;
		producto= new Producto();
		cliente= new Cliente();
		int numerocliente=0;
		boolean aux=false;
		boolean aux2=false;
		
		String buscar = Teclado.leerString("dime el titulo para alquilarlo");
		
		for (int i=0;i<datos1.size() &&aux==false;i++){
			producto=datos1.get(i);
			if (datos1.get(i).getTitulo().equals(buscar)){
				aux=true;
			if(datos1.get(i).getAlquilado()==false){
				numerocliente=Teclado.leerInt("dime el numero de cliente");
				for(int j =0;j<datos.size();j++){
				if (datos.get(j).getNumerocliente()==numerocliente &&aux2==false){
					aux2=true;
					if (cliente.getAux()==true){
						System.out.println("el cliente ya tiene un producto alquilado");
					}else{
						producto.setAlquilado(true);
						cliente.setAux(true);
						System.out.println("el producto "+datos1.get(j).getTitulo()+" esta alquilado al cliente numero: "+datos.get(j).getNumerocliente());
					}
				}
				}if(aux2==false){
					System.out.println("el cliente no existe o tiene un producto alquilado");
				}
			}else {
				System.out.println("el producto esta alquilado");
			}
			
			}
			
		}
		if(aux==false){
			System.out.println("el producto no existe");}
	}
	
	public static void devolverProducto (Vector <Producto>datos1,Vector <Cliente>datos){
		Producto producto;
		Cliente cliente;
		producto= new Producto();
		cliente= new Cliente();
		int numerocliente=0;
		String titulo;
		
		titulo = Teclado.leerString("dime el titulo para devolver");
		for (int i=0;i<datos1.size();i++){
			producto=datos1.get(i);
			if (datos1.get(i).getTitulo().equals(titulo)){
				
				if (datos1.get(i).getAlquilado()==false){
					numerocliente=Teclado.leerInt("dime el numero de cliente");
					if (datos.get(i).getNumerocliente()==numerocliente){
						if(datos.get(i).getAux()==false){
							
							producto.setAlquilado(false);
							cliente.setAux(false);
							System.out.println("el producto "+datos1.get(i).getTitulo()+" ha sido devuelto por el cliente numero: "+datos.get(i).getNumerocliente());
						}else{
							System.out.println("el cliente no tiene ningun producto alquilado");
						}
					}else {
						System.out.println("el cliente no existe");
					}
				}else {
					System.out.println("el producto no se encontra alquilado");
				}
			}else{
				System.out.println("el producto no existe");
			}
			
		}
	}
	public static void limpiar(int lineas)
	{
	for (int i=0; i < lineas; i++)
	{
	System.out.println();
	}
	}

}
