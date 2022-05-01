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

    private int panelWidth = 400;
    private int panelHeight = 400;

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

        walls.add(new Boundary(new PVector(10, 10), new PVector(10, panelHeight - 10)));
        walls.add(new Boundary(new PVector(10, panelHeight - 10), new PVector(panelWidth - 10, panelHeight - 10)));
        walls.add(new Boundary(new PVector(panelWidth - 10, panelHeight - 10), new PVector(panelWidth - 10, 10)));
        walls.add(new Boundary(new PVector(panelWidth - 10, 10), new PVector(10, 10)));

        walls.add(new Boundary(new PVector(70, 70), new PVector(70, panelHeight - 70)));
        walls.add(new Boundary(new PVector(70, panelHeight - 70), new PVector(panelWidth - 70, panelHeight - 70)));
        walls.add(new Boundary(new PVector(panelWidth - 70, panelHeight - 70), new PVector(panelWidth - 70, 70)));
        walls.add(new Boundary(new PVector(panelWidth - 70, 70), new PVector(70, 70)));

        // creating checkpoints
        checkpoints.add(new Boundary(new PVector(10, 10), new PVector(70, 70)));

        checkpoints.add(new Boundary(new PVector(10, (panelHeight - 20) / 4), new PVector(70, (panelHeight - 20) / 4)));
        checkpoints.add(new Boundary(walls.get(0).midPoint(), walls.get(4).midPoint()));
        checkpoints.add(
                new Boundary(new PVector(10, (panelHeight - 20) * 3 / 4), new PVector(70, (panelHeight - 20) * 3 / 4)));

        checkpoints.add(new Boundary(new PVector(10, panelHeight - 10), new PVector(70, panelHeight - 70)));

        checkpoints.add(new Boundary(new PVector((panelWidth - 20) / 4, panelHeight - 70),
                new PVector((panelWidth - 20) / 4, panelHeight - 10)));
        checkpoints.add(new Boundary(walls.get(1).midPoint(), walls.get(5).midPoint()));
        checkpoints.add(new Boundary(new PVector((panelWidth - 20) * 3 / 4, panelHeight - 70),
                new PVector((panelWidth - 20) * 3 / 4, panelHeight - 10)));

        checkpoints.add(new Boundary(new PVector(panelWidth - 10, panelHeight - 10),
                new PVector(panelWidth - 70, panelHeight - 70)));

        checkpoints.add(new Boundary(new PVector(panelWidth - 10, (panelHeight - 20) * 3 / 4),
                new PVector(panelWidth - 70, (panelHeight - 20) * 3 / 4)));
        checkpoints.add(new Boundary(walls.get(2).midPoint(), walls.get(6).midPoint()));
        checkpoints.add(new Boundary(new PVector(panelWidth - 10, (panelHeight - 20) / 4),
                new PVector(panelWidth - 70, (panelHeight - 20) / 4)));

        checkpoints.add(new Boundary(new PVector(panelWidth - 10, 10), new PVector(panelWidth - 70, 70)));

        checkpoints.add(
                new Boundary(new PVector((panelWidth - 20) * 3 / 4, 70), new PVector((panelWidth - 20) * 3 / 4, 10)));
        checkpoints.add(new Boundary(walls.get(3).midPoint(), walls.get(7).midPoint()));
        checkpoints.add(new Boundary(new PVector((panelWidth - 20) / 4, 70), new PVector((panelWidth - 20) / 4, 10)));
    
        logger.info("Track created");
    }

    @Override
    public List<Boundary> getCheckpoints() {
        return checkpoints;
    }

    @Override
    public PVector getEnd() {
        return null;
    }

    @Override
    public PVector getStart() {
        return checkpoints.get(0).midPoint();
    }

    @Override
    public PVector getStartVelocity() {
        return new PVector(-1, 1);
    }

    @Override
    public List<Boundary> getWalls() {
        return walls;
    }

}
