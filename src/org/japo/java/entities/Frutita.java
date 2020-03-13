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
import java.util.Random;

/**
 *
 * @author Adrian Bueno Olmedo - adrian.bueno.alum@iescamp.es
 */
public class Frutita {
    /*
     Objeto tipo Random para determinar posicion de la fruta
     Objeto tipo Point para representar la "frutita"
     */
    private final Random random;
    private final Point frutita;

    public Frutita() {
        random = new Random();
        frutita = new Point();
    }

//    Aleatorio de posicion de la "frutita"
    public void nuevaFrutita() {
        frutita.x = random.nextInt(30) + 10;
        frutita.y = random.nextInt(22) + 10;
    }

//    Forma de la "frutita"
    public void dibujoFrutita(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(frutita.x * 20, frutita.y * 20, 20, 20);
    }

//  Funcion para acceder al valor de la "frutita"
    public Point getFrutita() {
        return frutita;
    }
}
