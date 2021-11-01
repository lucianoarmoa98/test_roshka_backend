package com.example.demo.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@RequestMapping("/generala")
@CrossOrigin(origins = "*")
public class GeneralaController {

    @GetMapping("")
    public HashMap<String, Object> get()
    {
        String GENERALA = "GENERALA";
        String POKER = "POKER";
        String FULL = "FULL";
        String ESCALERA = "ESCALERA";
        String HUEVO = "HUEVO";

        int lanzar_a = (int) ((Math.random() * 6) + 1);
        int lanzar_b = (int) ((Math.random() * 6) + 1);
        int lanzar_c = (int) ((Math.random() * 6) + 1);
        int lanzar_d = (int) ((Math.random() * 6) + 1);
        int lanzar_e = (int) ((Math.random() * 6) + 1);

        HashMap<String, Object> map = new HashMap<>();
        map.put("dados", new int[]{lanzar_a, lanzar_b, lanzar_c, lanzar_d, lanzar_e});

        if(lanzar_a == lanzar_b && lanzar_b == lanzar_c && lanzar_c == lanzar_d && lanzar_d == lanzar_e){
            System.out.println("Son iguales: GENERALA");
            System.out.println(lanzar_a);
            System.out.println(lanzar_b);
            System.out.println(lanzar_c);
            System.out.println(lanzar_d);
            System.out.println(lanzar_e);
            map.put("jugada", GENERALA);
        }else if(lanzar_a == lanzar_b && lanzar_b == lanzar_c && lanzar_c == lanzar_d && lanzar_d != lanzar_e){
            System.out.println("Cuatro dados con el mismo valor: POKER");
            System.out.println(lanzar_a);
            System.out.println(lanzar_b);
            System.out.println(lanzar_c);
            System.out.println(lanzar_d);
            System.out.println(lanzar_e);
            map.put("jugada", POKER);
        }else if(lanzar_a == lanzar_b && lanzar_b == lanzar_c || lanzar_d == lanzar_e){
            System.out.println("Tres dados con el mismo valor, seguido de dos dados con el mismo valor: FULL");
            System.out.println(lanzar_a);
            System.out.println(lanzar_b);
            System.out.println(lanzar_c);
            System.out.println(lanzar_d);
            System.out.println(lanzar_e);
            map.put("jugada", FULL);
        }else if(lanzar_a < lanzar_b && lanzar_b < lanzar_c && lanzar_c < lanzar_d && lanzar_d < lanzar_e || lanzar_a > lanzar_b && lanzar_b > lanzar_c && lanzar_c > lanzar_d && lanzar_d > lanzar_e){
            System.out.println("Tres dados con el mismo valor, seguido de dos dados con el mismo valor: ESCALERA");
            System.out.println(lanzar_a);
            System.out.println(lanzar_b);
            System.out.println(lanzar_c);
            System.out.println(lanzar_d);
            System.out.println(lanzar_e);
            map.put("jugada", ESCALERA);
        } else {
            System.out.println("NINGUNA DE LAS ANTERIORES: HUEVO");
            System.out.println(lanzar_a);
            System.out.println(lanzar_b);
            System.out.println(lanzar_c);
            System.out.println(lanzar_d);
            System.out.println(lanzar_e);
            map.put("jugada", HUEVO);
        }

        map.put("tstamp", LocalDateTime.now());
        return map;
    }
}
