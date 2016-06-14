package application;

import graphUtil.GraphLoader;

/**
 * Created by Manu on 6/13/2016.
 */
public class DependencyTool{

    public static void main(String[] args) {
        GraphLoader graphLoader = new GraphLoader();
        graphLoader.loadDependencyFile("data\\GenUtil");
    }
}
