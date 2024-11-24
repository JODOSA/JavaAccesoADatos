package com.miapp;

import java.util.Arrays;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Cliente cliente = new Cliente("Joaquín", "Domínguez");

            Pedido pedido1 = new Pedido(100, cliente);
            Pedido pedido2 = new Pedido(250, cliente);

            cliente.setPedidos(Arrays.asList(pedido1, pedido2));

            em.persist(cliente);

            em.getTransaction().commit();

            em.getTransaction().begin();
            Cliente consultado = em.find(Cliente.class, cliente.getId());
            System.out.println("Cliente: " + consultado.getNombre() + " " + consultado.getApellido());
            for(Pedido pedido : consultado.getPedidos()){
                System.out.println("Pedido #" + pedido.getNum_pedido() + " Importe: €" + pedido.getImporte());
            }
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }
}
