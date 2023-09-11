/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.ws.testws.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author USUARIO
 */

//anotar clase modelo para xml: root y orden
@XmlRootElement(name = "persona")
@XmlType(propOrder = {"id","fullName","age","salario"})

public class Person {
    
    private int id;
    private String fullName;
    private int age;
    private double salario;
    //private double salarioMinimo= 1160000;
    
    public Person(){
        
    }
    
    @XmlElement
    public double getSalario() {
        return salario;
    } 
    
    @XmlElement
    public void setSalario(double salario) {
        this.salario = salario;
    } 
     
    // Método para calcular el salario
    double calcularSalario() {
        return (age * 1160000 ) / 3;
    }

    //Anotar metodos para extraer datos del modelo 
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
