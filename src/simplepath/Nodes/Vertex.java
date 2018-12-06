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
public class Vertex {
    //name of the vertex
    private String name;
    //next vertex of the adjacent list
    private Vertex down;
    //parent vertex of the adjacent list
    private Vertex parent;
    //edge of the vertex of the adjacent list
    private Edge list;
    public Vertex(String name){
        this.name = name;
        this.down = null;
        this.parent = null;
        this.list = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vertex getDown() {
        return down;
    }

    public void setDown(Vertex down) {
        this.down = down;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public Edge getList() {
        return list;
    }

    public void setList(Edge list) {
        this.list = list;
    }
    
}
