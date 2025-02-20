package tarea2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String nombre;
    String artista;
    static ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Cancion findSong(String titulo) {
        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                return cancion;
            }
        }
        return null;

    }

    public boolean addSong(String titulo, double duracion) {
        if (findSong(titulo) == null) {
            canciones.add(new Cancion(titulo, duracion));
            return true;

        }else{
            return false;
        }
    }
    public boolean addToPlayList(int numeroPista, LinkedList<Cancion>canciones){
        if(findSong(canciones.get(numeroPista).getTitulo())!=null && numeroPista>0 && numeroPista<canciones.size()){
            canciones.add(numeroPista, findSong(canciones.get(numeroPista).getTitulo()));
            return true;
        }else{
            return false;
        }
    }

    public boolean addToPlayList(String titulo, LinkedList<Cancion>canciones){
        if(findSong(titulo)!=null){
            canciones.add(findSong(titulo));
            return true;
        }else{
            return false;
        }
    }
    public static void printCanciones() {
        if (canciones.isEmpty()) {
            System.out.println("No se puede imprimir");
        }else {
            for (Cancion cancion : canciones) {
                System.out.println(" Canción: " + cancion.getTitulo());
            }
        }
        }


    }
