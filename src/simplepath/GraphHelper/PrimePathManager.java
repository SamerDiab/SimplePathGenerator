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
import simplepath.Nodes.Vertex;

/**
 *
 * @author Samer Diab
 */
public class PrimePathManager {
    private Vertex head = null;//root of the constructed graph
    private LoadGraphManager loadGraphManager;
    //queue to store simple paths during computation
    List<SimplePath> queue = new ArrayList<>();
    //storing simple paths after a path is explored
    List<SimplePath> explored = new ArrayList<>();

    public void setLoadGraphManager(LoadGraphManager loadGraphManager) {
        this.loadGraphManager = loadGraphManager;
    }
    
    /**
     * this method will generate prime paths
     */
    public void extractPrimePaths()
    {
        //loading root of the graph
        this.head = loadGraphManager.getHead();
        //initializing algorithm by loading each edge as simple path
        initialize();
        while(!queue.isEmpty())
        {
            SimplePath simplePath = queue.get(0);
            addSimplePathInExplored(simplePath);
            //check cycle for the simple path
            if(!isSimplePathCycle(simplePath))
            {
                //get edge list of current simple path
                List<Edge> edges = getEdges(simplePath.getEdges().get(simplePath.getEdges().size()-1).getVrt());
                for(Edge edge : edges)
                {
                    //check visited vertex and add into queue
                    if(!isVertexVisited(simplePath, edge))
                    {
                        appendSimplePathInQueue(simplePath, edge);
                    }
                }                
            }            
            queue.remove(0);
        }
        //print simple paths
        pringSimplePaths();
        //printing prime paths
        printPrimePath();
        
    }
    
    /**
     * this method will initialize each edge as simple path
     */
    public void initialize()
    {
        Vertex v = head;
        while(v != null){
            Edge edge = v.getList();
            while(edge != null)
            {
                List<Edge> edgeList = new ArrayList<>();
                edgeList.add(edge);
                SimplePath simplePath = new SimplePath();
                simplePath.setEdges(edgeList);
                simplePath.setTitle(edge.getFrom().getName() + "," + edge.getVrt().getName());
                queue.add(simplePath);
                edge = edge.getNext();                
            }
            v = v.getDown();
        }
    }
    
    /**
     * This method will check whether a simple path is cycle or not
     * @param simplePath simple path
     * @return boolean
     */
    public boolean isSimplePathCycle(SimplePath simplePath)
    {
        boolean isCycle = false;
        String title = simplePath.getTitle();
        String[] titleArray = title.split(",");
        if(titleArray != null && titleArray.length > 1)
        {
            if(titleArray[0].equals(titleArray[titleArray.length-1]))
            {
                isCycle = true;
            }
        }
        return isCycle;
    }
    
    /**
     * This method will return connected edges of a vertex
     * @param vertex vertex
     * @return List edge list
     */
    public List<Edge> getEdges(Vertex vertex)
    {
        List<Edge> edges = new ArrayList<>();
        Edge edge = vertex.getList();
        while(edge != null)
        {
            edges.add(edge);
            edge = edge.getNext();                
        }
        return edges;
    }
    
    /**
     * This method will check whether a new edge is inside of a simple path or not
     * @param simplePath  simple path
     * @param edge edge
     * @return boolean
     */
    public boolean isVertexVisited(SimplePath simplePath, Edge edge)
    {
        boolean isVisited = false;
        if(simplePath.getTitle().contains(edge.getVrt().getName()))
        {
            String title = simplePath.getTitle();
            String[] titleArray = title.split(",");
            if(titleArray != null && titleArray.length > 1)
            {
                if(titleArray[0].equals(edge.getVrt().getName()))
                {
                    return false;
                }
            }
            isVisited = true;
        }
        return isVisited;
    }
    
    /**
     * This method will add simple path into explored list
     * @param simplePath simple path
     */
    public void addSimplePathInExplored(SimplePath simplePath)
    {
        int length = simplePath.getEdges().size();
        if(explored.isEmpty())
        {
            explored.add(simplePath);
            return;
        }
        for(int counter = 0; counter < explored.size(); counter++)
        {
            if(explored.get(counter).getEdges().size() < length)
            {
                explored.add(counter, simplePath);
                return;
            }
        }
        explored.add(simplePath);
    }
    
    /**
     * This method will append new simple path based on new edge of a simple path
     * @param simplePath simple path
     * @param edge edge
     */
    public void appendSimplePathInQueue(SimplePath simplePath, Edge edge)
    {
        SimplePath newSimplePath = new SimplePath();
        for(Edge tempEdge: simplePath.getEdges())
        {
            newSimplePath.getEdges().add(tempEdge);
        }
        String title = simplePath.getTitle() + "," + edge.getVrt().getName();
        newSimplePath.setTitle(title);
        newSimplePath.getEdges().add(edge);
        queue.add(newSimplePath);
    }
    
    /**
     * This method will print all prime paths
     */
    public void printPrimePath()
    {
        System.out.println("Printing Prime Paths:");
        int totalPrimePaths = 0;
        boolean isPrimePath = true;
        int sourceCounter = 0;
        for(SimplePath sourceSimplePath : explored)
        {
            isPrimePath = true;
            String sourceTitle = sourceSimplePath.getTitle();
            int counter = 0;
            for(SimplePath simplePath : explored)
            {
                if(sourceCounter != counter)
                {
                    String title = simplePath.getTitle();
                    if(title.contains(sourceTitle))
                    {
                        isPrimePath = false;
                        break;
                    }
                }
                counter++;
            }
            if(isPrimePath)
            {
                totalPrimePaths++;
                System.out.println(sourceTitle);
            }
            sourceCounter++;
        }
        System.out.println("Total Prime Paths:" + totalPrimePaths);
    }
    
    public void pringSimplePaths()
    {
        int totalSimplePaths = 0;
        //printing 1 to n length simple paths
        for(SimplePath simplePath : explored)
        {
            String title = simplePath.getTitle();
            System.out.println(title);
            totalSimplePaths++;
        }
        //printing 0 length paths
        Vertex v = head;
        while(v != null){
            System.out.println(v.getName());
            totalSimplePaths++;
            v = v.getDown();
        }
        System.out.println("Total Simple Paths:" + totalSimplePaths);
    }
}
