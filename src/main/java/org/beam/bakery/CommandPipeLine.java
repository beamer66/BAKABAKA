package org.beam.bakery;

import org.beam.abstractClasses.Cake;
import org.beam.utils.VisualDelay;
import org.beam.repositories.Command;
import java.util.ArrayList;

public class CommandPipeLine {
    private ArrayList<Command> pipeline;

    public CommandPipeLine() {
        pipeline = new ArrayList<>();

    }

    public void addCommand(Command command) {
        pipeline.add(command);
    }

    public Cake execute(Cake cake, ArrayList recipe) {
        System.out.println("###Påbörjar Finishen...###");
        VisualDelay.getInstance().simulateDelay();

        int initialPipelineSize = pipeline.size();

        for(int i=0; i<initialPipelineSize; i++) {
            cake = pipeline.get(0).addIngredient(cake, recipe);
            pipeline.remove(0);
            VisualDelay.getInstance().simulateDelay();
        }
        return cake;
    }
}
