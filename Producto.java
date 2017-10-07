package videoclub;


import daw.com.Teclado;

public class Producto {
private String titulo,tipo;
private int precio,plazo;
private boolean alquilado;


//constructores
public Producto(){
	titulo="";
	tipo="peli";
	precio=0;
	plazo=7;
	alquilado=false;
}
public Producto(Producto original){
	this.titulo=original.titulo;
	this.tipo=original.tipo;
	this.precio=original.precio;
	this.plazo=original.plazo;
}
//selectores y modificadores
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	
	
if (tipo.equalsIgnoreCase("peli") || tipo.equalsIgnoreCase("videojuego"))
this.tipo = tipo;
		
	
}
public int getPrecio() {
	if(precio < 0)
		precio=0;
	return precio;
}
public void setPrecio(int precio) {
	this.precio = precio;
}
public int getPlazo() {
	return plazo;
}
public void setPlazo(int plazo) {
	this.plazo = plazo;
}
public boolean getAlquilado() {
	return alquilado;
}
public void setAlquilado(boolean alquilado) {
	String respuesta=Teclado.leerString("s asignar/n des-asignar)?");
	if (respuesta.equals("s") && alquilado==false){
		alquilado=true;
		}else {
		alquilado=false;
		}
	this.alquilado = alquilado;
}
public void leerDatos(){
	
	setTipo(Teclado.leerString("Dime el tipo de producto (videojuego/peli)"));
	setTitulo(Teclado.leerString("dime el titulo del producto "+tipo));
	setPrecio(Teclado.leerInt("dime el precio del producto"));
	setPlazo(Teclado.leerInt("dime el plazo de devolucion"));
	
}

public void mostrarDatos(){
	System.out.println("-------ficha de producto---------");
	System.out.println("el titulo del producto es:"+getTitulo());
	System.out.println("el tipo del producto es:"+""+getTipo());
	System.out.println("el precio del producto es:"+""+getPrecio());
	System.out.println("el plazo de entrega del producto es:"+""+getPlazo());
	System.out.println("--------------------------------");
}

}
