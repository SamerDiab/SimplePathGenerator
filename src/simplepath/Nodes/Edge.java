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
package simplepath.Nodes;

/**
 *
 * @author Samer Diab
 */
public class Edge {
    //next edge reference of source vertex
    private Edge next;
    //edge between two vertices A to B where A is from and B is vrt
    private Vertex from;
    private Vertex vrt;    

    public Edge getNext() {
        return next;
    }

    public void setNext(Edge next) {
        this.next = next;
    }

    public Vertex getVrt() {
        return vrt;
    }

    public void setVrt(Vertex vrt) {
        this.vrt = vrt;
    }

    public Vertex getFrom() {
        return from;
    }

    public void setFrom(Vertex from) {
        this.from = from;
    }
    
}
