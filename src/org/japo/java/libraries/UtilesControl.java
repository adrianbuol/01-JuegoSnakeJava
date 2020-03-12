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
package org.japo.java.libraries;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.japo.java.entities.Frutita;
import org.japo.java.entities.Snake;

/**
 *
 * @author Adrian Bueno Olmedo - adrian.bueno.alum@iescamp.es
 */
public class UtilesControl implements KeyListener {

    public Snake snake;
    public Frutita frutita;

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
