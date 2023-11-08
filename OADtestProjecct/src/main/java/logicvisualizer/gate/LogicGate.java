package logicvisualizer.gate;

import logicvisualizer.node.ConnectorHolder;
import logicvisualizer.node.Node;
import logicvisualizer.node.ValueReturner;

import java.awt.*;

public abstract class LogicGate extends Node implements ValueReturner, ConnectorHolder {

    protected abstract void renderGate(Graphics graphics);

}
