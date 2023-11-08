package logicvisualizer.node;

import logicvisualizer.gate.GateConnector;

import java.util.List;

/**
 * Represents a node with gate connectors
 */
public interface ConnectorHolder {

    /**
     * Returns all gate connectors of this node
     *
     * @return The gate connectors
     */
    List<GateConnector> getConnectors();

}
