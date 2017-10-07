package videoclub;

import daw.com.Teclado;

public class Cliente {
private String nombre,direccion;
private int numerocliente,telefono;
private boolean aux;


//constructores
public Cliente(){
	nombre="";
	direccion="";
	numerocliente=0;
	telefono=999999999;
	aux=false;
}
public Cliente(Cliente original){
	this.nombre=original.nombre;
	this.direccion=original.direccion;
	this.numerocliente=original.numerocliente;
	this.telefono=original.telefono;
}
//selectores y modificadores
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public int getNumerocliente() {
	return numerocliente;
}
public boolean getAux() {
	return aux;
}
public void setAux(boolean aux) {
	
	this.aux = aux;
}
public void setNumerocliente(int numerocliente) {
	
	this.numerocliente = numerocliente;
}
public int getTelefono() {
	
	return telefono;
}
public void setTelefono(int telefono) {
	
	this.telefono = telefono;
}
public void leerDatos(){
	
	setNumerocliente(Teclado.leerInt("dime el numero de cliente"));
	setNombre(Teclado.leerString("dime el nombre del cliente"));
	setDireccion(Teclado.leerString("dime la direccion del cliente"));
	setTelefono(Teclado.leerInt("dime el telefono del cliente"));
	
}

public void mostrarDatos(){
	System.out.println("-------ficha de cliente---------");
	System.out.println("el numero del cliente es:"+""+getNumerocliente());
	System.out.println("el nombre del cliente es:"+""+getNombre());
	System.out.println("el direccion del cliente es:"+""+getDireccion());
	System.out.println("el telefono del cliente es:"+""+getTelefono());
	System.out.println("---------------------------------");
}
}
