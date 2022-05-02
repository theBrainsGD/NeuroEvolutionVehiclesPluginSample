package com.JayPi4c.track;

import java.util.ArrayList;
import java.util.List;

import com.JayPi4c.NeuroEvolution.plugins.track.Track;
import com.JayPi4c.NeuroEvolution.plugins.util.Boundary;
import com.JayPi4c.NeuroEvolution.plugins.util.PVector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTrack implements Track {

    private Logger logger = LoggerFactory.getLogger(MyTrack.class);

    private List<Boundary> walls;
    private List<Boundary> checkpoints;

    public String getTrackName() {
        return "PluginTrack";
    }

    @Override
    public void buildTrack() {
        logger.info("Creating new Track");
        walls = new ArrayList<>();
        checkpoints = new ArrayList<>();

        walls.add(new Boundary(new PVector(0.05, 0.05), new PVector(0.05, 1 - 0.05)));
        walls.add(new Boundary(new PVector(0.05, 1 - 0.05), new PVector(1 - 0.05, 1 - 0.05)));
        walls.add(new Boundary(new PVector(1 - 0.05, 1 - 0.05), new PVector(1 - 0.05, 0.05)));
        walls.add(new Boundary(new PVector(1 - 0.05, 0.05), new PVector(0.05, 0.05)));

        walls.add(new Boundary(new PVector(0.2, 0.2), new PVector(0.2, 1 - 0.2)));
        walls.add(new Boundary(new PVector(0.2, 1 - 0.2), new PVector(1 - 0.2, 1 - 0.2)));
        walls.add(new Boundary(new PVector(1 - 0.2, 1 - 0.2), new PVector(1 - 0.2, 0.2)));
        walls.add(new Boundary(new PVector(1 - 0.2, 0.2), new PVector(0.2, 0.2)));

        // creating checkpoints
        checkpoints.add(new Boundary(new PVector(0.05, 0.05), new PVector(0.2, 0.2)));

        checkpoints.add(new Boundary(new PVector(0.05, 0.05 + (1 - 0.1) / 4), new PVector(0.2, 0.05 + (1 - 0.1) / 4)));
        checkpoints.add(new Boundary(walls.get(0).midPoint(), walls.get(4).midPoint()));
        checkpoints.add(
                new Boundary(new PVector(0.05, 0.05 + (1 - 0.1) * 3 / 4), new PVector(0.2, 0.05 + (1 - 0.1) * 3 / 4)));

        checkpoints.add(new Boundary(new PVector(0.05, 1 - 0.05), new PVector(0.2, 1 - 0.2)));

        checkpoints.add(new Boundary(new PVector(0.05 + (1 - 0.1) / 4, 1 - 0.2),
                new PVector(0.05 + (1 - 0.1) / 4, 1 - 0.05)));
        checkpoints.add(new Boundary(walls.get(1).midPoint(), walls.get(5).midPoint()));
        checkpoints.add(new Boundary(new PVector(0.05 + (1 - 0.1) * 3 / 4, 1 - 0.2),
                new PVector(0.05 + (1 - 0.1) * 3 / 4, 1 - 0.05)));

        checkpoints.add(new Boundary(new PVector(1 - 0.05, 1 - 0.05),
                new PVector(1 - 0.2, 1 - 0.2)));

        checkpoints.add(new Boundary(new PVector(1 - 0.05, 0.05 + (1 - 0.1) * 3 / 4),
                new PVector(1 - 0.2, 0.05 + (1 - 0.1) * 3 / 4)));
        checkpoints.add(new Boundary(walls.get(2).midPoint(), walls.get(6).midPoint()));
        checkpoints.add(new Boundary(new PVector(1 - 0.05, 0.05 + (1 - 0.1) / 4),
                new PVector(1 - 0.2, 0.05 + (1 - 0.1) / 4)));

        checkpoints.add(new Boundary(new PVector(1 - 0.05, 0.05), new PVector(1 - 0.2, 0.2)));

        checkpoints.add(
                new Boundary(new PVector(0.05 + (1 - 0.1) * 3 / 4, 0.2), new PVector(0.05 + (1 - 0.1) * 3 / 4, 0.05)));
        checkpoints.add(new Boundary(walls.get(3).midPoint(), walls.get(7).midPoint()));
        checkpoints.add(new Boundary(new PVector(0.05 + (1 - 0.1) / 4, 0.2), new PVector(0.05 + (1 - 0.1) / 4, 0.05)));
    
        logger.info("Track created");
    }

    @Override
    public List<Boundary> getCheckpoints() {
        return checkpoints;
    }

    @Override
    public PVector getStart() {
        return checkpoints.get(0).midPoint();
    }

    @Override
    public PVector getStartVelocity() {
        return new PVector(-1/400d, 1/400d).normalize();
    }

    @Override
    public List<Boundary> getWalls() {
        return walls;
    }

}
