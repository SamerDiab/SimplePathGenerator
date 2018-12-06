/* 
 * Copyright 2018 Samer Diab.
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
package simplepath;

import simplepath.GraphHelper.PrimePathManager;
import simplepath.GraphHelper.LoadGraphManager;

/**
 *
 * @author Samer Diab
 */
public class SimplePathMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoadGraphManager loadGraphManager = new LoadGraphManager();
        //loading input of the graph
        loadGraphManager.loadinput();
        PrimePathManager primePathManager = new PrimePathManager();
        primePathManager.setLoadGraphManager(loadGraphManager);
        //extracting prime paths
        primePathManager.extractPrimePaths();
    }
    
}
