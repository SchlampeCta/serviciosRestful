/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.ws.testws.entidad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

        


/**
 *
 * @author USUARIO
 */
@Path("service")
public class Service {
    
    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();
    
    
    static {
        for (int i = 0;i <10; i++){
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("My wonderfull person" + id);
            person.setAge(new Random().nextInt(40) + 1);
            person.setSalario(id);
            persons.put(id, person);
        }
    }
    
    
    
    ///1.DEFINIR METODO POR CADA SERVICIO
    ///2.ANOTACIONES DE LOS METODOS
    
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id){
        return persons.get(id);
    }
    
    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id){
        return persons.get(id);
    }
    
    @GET
    @Path("getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML(){
        return new ArrayList<Person>(persons.values());
    }
    
    @GET
    @Path("getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson(){
        return new ArrayList<Person>(persons.values());
    }
    
    @POST
    @Path("getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public Person addPersonInJson (Person person){
        System.out.println(person.getId());
        persons.put(new Integer(person.getId()), person);
        return person;
    }
    
    //Conocer el salario promedio en formato XML
    @GET
    @Path("getsalarioPromedioInXML")
    @Produces(MediaType.APPLICATION_XML)
    public double salarioPromedioInXML(int age) {
        Collection<Person> personas = persons.values();

        // Calcular el salario promedio
        double sumaSalarios = 0;
        //for (Person person : personas) {
         //   sumaSalarios += person.calcularSalario();
       // }
        double salarioPromedio = (age * 1160000 ) / 3;
        return salarioPromedio;
}

    //suma de los salarios de las personas en formato JSON
    @GET
    @Path("getsumSalarios")
    @Produces(MediaType.APPLICATION_JSON)
    public double getSumaSalarios() {
    double sumaSalarios = 0;

       for (Person person : persons.values()) {
        sumaSalarios += person.getSalario();
       }
         return sumaSalarios;
    }

}
