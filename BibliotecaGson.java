/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.universidade.poo.biblioteca;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author António Neves José
 */
public class BibliotecaGson {
    
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void salvar( Biblioteca biblioteca,String ficheiro) {

        try (FileWriter writer = new FileWriter(ficheiro)) {

            gson.toJson( biblioteca, writer );

            System.out.println("Dados guardados com sucesso.");

        } catch (IOException e) {

            System.out.println( "Erro ao guardar dados.");
        }
    }

    public static Biblioteca carregar( String ficheiro) {

        try (FileReader reader = new FileReader(ficheiro)) {

            return gson.fromJson( reader,Biblioteca.class);

        } catch (IOException e) {

            System.out.println( "Erro ao carregar dados.");

            return null;
        }
    }

    static class Json {

        public Json() {
        }
    }

 
   }
