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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import simplepath.Nodes.Edge;
import simplepath.Nodes.Vertex;

/**
 *
 * @author Samer Diab
 */
public class LoadGraphManager {
    private Vertex head = null;//root of the constructed graph

    /**
     * this method will return root of the graph
     * @return Vertex root of the graph
     */
    public Vertex getHead() {
        return head;
    }
    
    /**
     * This method will load input.txt and construct the graph
     */
    public void loadinput(){
        int flag = 1;
        String node1,node2,strLine;
        try
        {
            FileInputStream fstream = new FileInputStream("input.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null)   {
                String[] inputLineArray = strLine.split(" ");
                if(inputLineArray != null && inputLineArray.length == 2)
                {
                    //first node of an edge
                    node1 = inputLineArray[0];
                    //second node of an edge
                    node2 = inputLineArray[1];  
                    
                    if(flag == 1){
                        //setting the root for once
                        initializeRoot(node1);
                        flag = 0;
                    }
                    else{
                        if(!isVertexExist(node1))
                            setVertex(node1);
                    }
                    if(!isVertexExist(node2))
                        setVertex(node2);

                    setEdge(node1,node2);
                }                
            }
            in.close();//close the file
        }
        catch (Exception ex)
        {
            System.out.println("Exception occurs!!" + ex.toString());
        }
    }
    
    /**
     * initializing the root of the graph
     * @param nodeName vertex name
    */
    public void initializeRoot(String nodeName){
        if(head == null)
        {
            head = new Vertex(nodeName);
        }        		
    }
    
    /**
    * this method will check whether a vertex exists or not
    * @param name name of the vertex
    * @return boolean where vertex exists or not
    */
    public boolean isVertexExist(String name){
        String temp;
        Vertex v1;
        v1 = head;
        while(true){
            temp = v1.getName();
            if(temp.equals(name))
                return true;
            if(v1.getDown() == null)
                    break;
            v1 = v1.getDown();
        }
        return false;
    }
    
    /**
     * This method will add a new vertex into the graph
     * @param nodeName vertex name
     */
    public void setVertex(String nodeName){
        Vertex v1;
        v1 = head;
        while(v1.getDown() != null){
                v1 = v1.getDown();
        }
        Vertex v2 = new Vertex(nodeName);
        v2.setDown(v1.getDown());
        v1.setDown(v2);
        v2.setParent(v1);
    }
    
    /**
     * This method will return vertex
     * @param name vertex name
     * @return Vertex vertex
     */
    public Vertex getVertex(String name){
        Vertex v;
        v = head;
        while(v != null){
            if(v.getName().equals(name))
                return v;
            else
                v = v.getDown();
        }
        return null;
    }
    
    /**
     * This method will add new edge between two vertices
     * @param name1 source vertex name
     * @param name2 destination vertex name
     */
    public void setEdge(String name1, String name2){
		
        Vertex first = null,second = null;
        first = getVertex(name1);
        second = getVertex(name2);
        Edge p = new Edge();
        Edge q;
        p.setFrom(first);
        p.setVrt(second);
        if(first.getList() == null){
            p.setNext(null);
            first.setList(p);
        }
        else{
            q = first.getList();
            while(q.getNext() != null)
                q = q.getNext();
            p.setNext(null);
            q.setNext(p);
        }
    }
}
