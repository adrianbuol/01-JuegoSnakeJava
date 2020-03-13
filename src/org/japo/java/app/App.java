/*
 * Copyright 2019 Adrian Bueno Olmedo - adrian.bueno.alum@iescamp.es.
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

import org.japo.java.app.Game.JuegoSnakeJava;
import org.japo.java.libraries.UtilesPantalla;


/**
 *
 * @author Adrián Bueno Olmedo <adrian.bueno.alum@iescamp.es>
 */
public final class App {   
        
    public App(){
        System.out.println(UtilesPantalla.TXT_MENSAJE);
        
    }
    
    public final void launchApp() {
        JuegoSnakeJava game = new JuegoSnakeJava();
        game = new JuegoSnakeJava();
    }    

}
