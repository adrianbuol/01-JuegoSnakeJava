/*
 * Copyright 2020 Adrian Bueno Olmedo - <adrian.bueno.alum@iescamp.es>.
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
package org.japo.java.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.japo.java.entities.Frutita;
import org.japo.java.entities.Snake;

/**
 *
 * @author Adrian Bueno Olmedo - <adrian.bueno.alum@iescamp.es>
 */
public class Game {

    public static class JuegoSnakeJava extends JFrame implements KeyListener {

//      Variables del tamaño de la ventana
//        private final int windowWidth = 1280;
//        private final int windowHeight = 800;
        private final int windowWidth = 800;
        private final int windowHeight = 600;

//      Variables de elementos del juego
        private Snake snake;
        private Frutita frutita;

//      Variables de "gameplay"
        public static int score;
        private long goal;

//      Velocidad serpiente
        public static int vel = 70;

        public JuegoSnakeJava() {

//          Propiedades de ventana
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(windowWidth, windowHeight);
            this.setResizable(false);
            this.setLocation(100, 100);
            this.setVisible(true);

//          Redibujar pantalla sin cortes
            this.createBufferStrategy(2);
//          Interfaz control
            this.addKeyListener(this);

            inicioObjetos();

            while (true) {
                juego();
                sleep();
            }
        }

        private void inicioObjetos() {
            snake = new Snake();
            snake.crecerSnake();
            frutita = new Frutita();
            frutita.nuevaFrutita();
            score = 0;
        }

        private void dibujoPantalla() {

            BufferStrategy bf = this.getBufferStrategy();
            Graphics g = null;

            try {
                g = bf.getDrawGraphics();

                g.setColor(Color.BLACK);
                g.fillRect(0, 0, windowWidth, windowHeight);

                frutita.dibujoFrutita(g);
                snake.dibujoSnake(g);
                muestroPuntos(g);

            } finally {
                g.dispose();
            }

            bf.show();

            Toolkit.getDefaultToolkit().sync();
        }

//        public void bordePantalla() {
//            JLabel label = new JLabel("Game Made by adrianbuol",
//                    JLabel.SOUTH_WEST);
//        }
        private void checkColision() {

//          Serpiente alcanza frutita //getLargo().get(0).
            if (snake.getLargo().get(0).equals(frutita.getFrutita())) {
                frutita.nuevaFrutita();
                snake.crecerSnake();
                score += 50;

            }

//          Serpiente alcanza limite de pantalla
            if (snake.getLargo().get(0).x < 0
                    || snake.getLargo().get(0).x > 39
                    || snake.getLargo().get(0).y < 1
                    || snake.getLargo().get(0).y > 29) {
                inicioObjetos();
            }

//          Deteccion general de colision
            for (int n = 1; n < snake.getLargo().size(); n++) {
                if (snake.getLargo().get(0).equals(snake.getLargo().get(n))
                        && snake.getLargo().size() > 2) {
                    inicioObjetos();
                }

            }
        }

        private void muestroPuntos(Graphics g) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.drawString("Score: " + score, 20, 50);
        }

        private void juego() {
//          Llamada metodo actualizar posicion de la serpiente
            snake.muevoSnake();
//          Llamada metodo para comprobar si hay colision  
            checkColision();
//          Llamada metodo para representar por pantalla que ocurre
            dibujoPantalla();
//          Llamada metodo borde pantalla
//            bordePantalla();
        }

        private void sleep() {
//          Velocidad base snake
            goal = (System.currentTimeMillis() + vel);
//          Incremento velocidad
            switch (score) {
                case 150:
                    goal = (System.currentTimeMillis() + vel - 10);
                    break;
                case 200:
                case 250:
                case 300:
                case 350:
                    goal = (System.currentTimeMillis() + vel - 20);
                    break;
                case 400:
                case 450:
                case 500:
                case 550:
                case 600:
                    goal = (System.currentTimeMillis() + vel - 30);
                    break;
                case 650:
                case 700:
                case 750:
                case 800:
                    goal = (System.currentTimeMillis() + vel - 40);
                    break;
                case 850:
                case 900:
                case 950:
                case 1000:
                case 1050:
                    goal = (System.currentTimeMillis() + vel - 50);
                    break;
                case 1100:
                case 1150:
                case 1200:
                case 1250:
                    goal = (System.currentTimeMillis() + vel - 60);
                    break;
                default:
                    break;
            }
            while (System.currentTimeMillis() < goal) {
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

            int tecla = e.getKeyCode();

            switch (tecla) {
                case KeyEvent.VK_UP:
                    snake.direccion("ARR");
                    break;
                case KeyEvent.VK_DOWN:
                    snake.direccion("ABA");
                    break;
                case KeyEvent.VK_LEFT:
                    snake.direccion("IZQ");
                    break;
                case KeyEvent.VK_RIGHT:
                    snake.direccion("DER");
                    break;
                case KeyEvent.VK_ESCAPE:
                    System.exit(0);
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

    }
}
