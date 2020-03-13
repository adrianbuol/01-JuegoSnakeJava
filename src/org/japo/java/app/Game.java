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
import org.japo.java.entities.Frutita;
import org.japo.java.entities.Snake;

/**
 *
 * @author Adrian Bueno Olmedo - <adrian.bueno.alum@iescamp.es>
 */
public class Game {

    public static final class JuegoSnakeJava 
            extends JFrame implements KeyListener {

        private static final long serialVersionUID = -2260931690081532922L;

//      Variables del tamaño de la ventana
        private final int windowWidth = 880;
        private final int windowHeight = 700;
        private final int gameWindowW = 800;
        private final int gameWindowH = 580;

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

                g.setColor(Color.PINK);
                g.fillRect(0, 0, windowWidth, windowHeight);
                g.setColor(Color.BLACK);
                g.fillRect(40, 80, gameWindowW, gameWindowH);
                g.setColor(Color.BLUE);
                g.drawRect(0, 0, 200, 80);
                g.setColor(Color.DARK_GRAY);
                g.fillRect(0, 0, 200, 80);

                frutita.dibujoFrutita(g);
                snake.dibujoSnake(g);
                muestroPuntos(g);

            } finally {
                g.dispose();
            }

            bf.show();

            Toolkit.getDefaultToolkit().sync();
        }

        private void checkColision() {

//          Serpiente alcanza frutita //getLargo().get(0).
            if (snake.getLargo().get(0).equals(frutita.getFrutita())) {
                frutita.nuevaFrutita();
                snake.crecerSnake();
                score += 50;
            }

//          Colision limite pantalla
            if (snake.getLargo().get(0).x < 2            // 0 ANTES
                    || snake.getLargo().get(0).x > 41    // 39 ANTES
                    || snake.getLargo().get(0).y < 3.25  // 1 ANTES
                    || snake.getLargo().get(0).y > 32) { // 29 ANTES
                inicioObjetos();
            }

//          Deteccion colision snake consigo misma
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
            g.drawString("Score: " + score, 30, 70);
        }

        private void juego() {
//          Llamada metodo actualizar posicion de la serpiente
            snake.muevoSnake();
//          Llamada metodo para comprobar si hay colision  
            checkColision();
//          Llamada metodo para representar por pantalla que ocurre
            dibujoPantalla();
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

        public void sleep() {

//          Velocidad base snake
            goal = (System.currentTimeMillis() + vel);

//          Incremento velocidad
            switch (score) {
                case 150:
                case 200:
                case 250:
                case 300:
                case 350:
                    goal = (System.currentTimeMillis() + vel - 10);
                    break;
                case 400:
                case 450:
                case 500:
                case 550:
                case 600:
                case 650:
                    goal = (System.currentTimeMillis() + vel - 20);
                    break;
                case 700:
                case 750:
                case 800:
                case 850:
                case 900:
                    goal = (System.currentTimeMillis() + vel - 30);
                    break;
                case 950:
                case 1000:
                case 1050:
                case 1100:
                case 1150:
                    goal = (System.currentTimeMillis() + vel - 40);
                    break;
                case 1200:
                case 1250:
                case 1300:
                case 1350:
                case 1400:
                case 1450:
                case 1500:
                case 1550:
                    goal = (System.currentTimeMillis() + vel - 50);
                    break;
                case 1600:
                case 1650:
                case 1700:
                case 1750:
                case 1800:
                case 1850:
                case 1900:
                case 1950:
                case 2000:
                    goal = (System.currentTimeMillis() + vel - 60);
                    break;
                default:
                    break;
            }
            while (System.currentTimeMillis() < goal) {
            }
        }
    }
}
