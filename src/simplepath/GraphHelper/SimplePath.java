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
package simplepath.GraphHelper;

import java.util.ArrayList;
import java.util.List;
import simplepath.Nodes.Edge;

/**
 *
 * @author Samer Diab
 */
public class SimplePath {
    //list of edges of a simple path
    private List<Edge> edges;
    //title of the simple path which is sequence of vertices names seperated by comma(,)
    private String title;
    public SimplePath()
    {
        edges = new ArrayList<>();
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
