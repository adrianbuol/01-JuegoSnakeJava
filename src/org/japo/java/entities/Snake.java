/*
 * Copyright 2020 Adrian Bueno Olmedo - adrian.bueno.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Adrian Bueno Olmedo - adrian.bueno.alum@iescamp.es
 */
public class Snake {

    /*
    Array list para el largo de la serpiente, clase point representa 
    localización en (x,y)
    Variables snakeX y snakeY para controlar la posicion
     */
    private ArrayList<Point> largo = new ArrayList<Point>();
    public static double snakeX = 0;
    public static double snakeY = 0;
    

//  Posición predeterminada (Centro de la pantalla)
    public Snake() {
        largo.add(new Point(20, 15));
    }

    public ArrayList<Point> getLargo() {
        return largo;
    }

//  Forma de la serpiente (Recorre la lista y muestra los puntos del cuerpo)
    public void dibujoSnake(Graphics g) {
        for (int n = 0; n < largo.size(); n++) {
            g.setColor(Color.GREEN);
            Point p = largo.get(n);
            g.fillRect(p.x * 20, p.y * 20, 20, 20);
        }
    }

//  Movimiento de la serpiente, la cabeza (0) esta fuera del bucle
    public void muevoSnake() {
        for (int n = largo.size() - 1; n > 0; n--) {
            largo.get(n).setLocation(largo.get(n - 1));
        }
        largo.get(0).x += snakeX;
        largo.get(0).y += snakeY;
    }

//  Aumento de tamaño de la cola de la serpiente
    public void crecerSnake() {
        largo.add(new Point());
    }

//  Controles de la serpiente
    public void direccion(String d) {
        switch (d) {
            case "ARR":
                snakeX = 0.0;
                snakeY = -1.0;
                break;
            case "ABA":
                snakeX = 0.0;
                snakeY = 1.0;
                break;
            case "IZQ":
                snakeX = -1.0;
                snakeY = 0.0;
                break;
            case "DER":
                snakeX = 1.0;
                snakeY = 0.0;
                break;
        }
    }

}
