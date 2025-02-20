package tarea2;

import java.util.*;

public class Main {
   static ArrayList<Album> albumes = new ArrayList<>();
    public static void main(String[] args) {
        LinkedList<Cancion> canciones = new LinkedList<>();

        Album album1 = new Album("Spanish", "Julio Iglesias");
        Album album2 = new Album("New York", "Taylor Swift");

        album1.addSong("Eye of the tiger", 4);
        album1.addToPlayList("Eye of the tiger", canciones);

        album1.addSong("The best", 6);
        album1.addToPlayList("The best", canciones);

        album1.addSong("Tragedy", 4);
        album1.addToPlayList("Tragedy", canciones);

        album2.addSong("Bee Gees", 9);
        album2.addToPlayList("Bee Gees", canciones);

        album2.addSong("Te necesito", 5);
        album2.addToPlayList("Te necesito", canciones);

        album2.addSong("Mr Magic", 8);
        album2.addToPlayList("Mr Magic", canciones);

        album1.addToPlayList(1, canciones);
        album2.addToPlayList(3, canciones);

        play(canciones);
    }

    public static void printlistaReproduccion(LinkedList<Cancion> canciones) {
        Iterator<Cancion> iterar = canciones.iterator();
        while(iterar.hasNext()){
            System.out.println(iterar.next());
        }
    }

    public static void printMenu() {
        System.out.println("Menú\n" +
                "0. Salir de la lista de reproducción\n" +
                "1. Reproducir siguiente canción en la lista\n" +
                "2. Reproducir la canción previa de la lista\n" +
                "3. Repetir la canción actual\n" +
                "4. Imprimir la lista de canciones en la playlist\n" +
                "5. Volver a imprimir el menú\n" +
                "6. Eliminar canción actual de la playlist\n" +
                "7. Imprimir canciones de un album\n");

    }

    public static void printAlbum(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduce el nombre del album:");
        String album= scanner.nextLine();
        for(Album albumNombre:albumes){
            if(albumNombre.getNombre().equalsIgnoreCase(album)){

            }
        }
    }


    public static void play(LinkedList<Cancion> canciones) {
        boolean haciaDelante=true;
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int numero=1;
        ListIterator<Cancion> iterar = canciones.listIterator();
        while (numero != 0) {
            System.out.println("Introduce la opción que desee:");
            numero = scanner.nextInt();
            switch (numero) {
                case 0:
                    System.out.println("Saliendo de la lista de reproducción");
                    break;
                case 1:
                    if (!iterar.hasNext()) {
                        System.out.println("Estás al final de la lista, no puedes avanzar más.");
                    } else {
                        if (!haciaDelante) { // Si veníamos retrocediendo, ajustamos el iterador
                            iterar.next();
                        }
                        System.out.println("Reproduciendo: " + iterar.next());
                        haciaDelante = true; // Marcamos que ahora estamos avanzando
                    }
                    break;


                case 2:
                    if (!iterar.hasPrevious()) {
                        System.out.println("Estás al inicio de la lista, no puedes retroceder más.");
                    } else {
                        if (haciaDelante) { // Si veníamos avanzando, ajustamos el iterador
                            iterar.previous();
                        }
                        System.out.println("Reproduciendo: " + iterar.previous());
                        haciaDelante = false; // Marcamos que ahora estamos retrocediendo
                    }
                    break;


                case 3:
                    if (haciaDelante && iterar.hasPrevious()) {
                        System.out.println("Reproduciendo la anterior: " + iterar.previous());
                        iterar.next();
                    } else if (!haciaDelante && iterar.hasNext()) {
                        System.out.println("Reproduciendo la siguiente: " + iterar.next());
                        iterar.previous();
                    }
                    break;

                case 4:
                    printlistaReproduccion(canciones);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    iterar.remove();
                    if (iterar.hasNext()) {
                        System.out.println(iterar.next());
                    } else {
                        System.out.println(iterar.previous());
                    }
                    break;

                case 7:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Introduce el nombre del album a imprimir");
                    String album = scanner2.nextLine();
                    boolean encontrado = false;
                    for (Album albumes : albumes) {
                        if (albumes.getNombre().equalsIgnoreCase(album)) {
                            albumes.printCanciones();
                            encontrado=true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No existe");
                    }
                    break;
            }

            }
        }
    }



