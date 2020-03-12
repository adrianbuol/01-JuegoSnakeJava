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
package org.japo.java.Main;

import org.japo.java.app.App;

/**
 *
 * @author Adrian Bueno Olmedo - adrian.bueno.alum@iescamp.es
 */
public final class Main {

    private static final String ACCESS_UID = "JAPO-Omicron-0";
    
    public final App app;
    
    public Main () {
        app = new App();
    }
    
    public static final void main(String[] args) {
        if (args.length == 1 && args[0].equals(ACCESS_UID)) {
            Main main = new Main();
            
            main.app.launchApp();
        } else {
            System.out.println("ACCESO DENEGADO");
            System.out.println("---");
            System.out.println("Contacte con su servicio Técnico");

        }
    }

}
