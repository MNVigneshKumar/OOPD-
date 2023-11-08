package logicvisualizer.node;

import logicvisualizer.gate.impl.*;
import logicvisualizer.gate.impl.*;
import logicvisualizer.input.impl.DefaultInput;
import logicvisualizer.output.impl.DefaultOutput;

/**
 * This enum maps nodes by their visible name to their add action.

 */
public enum NodeMap {

    AND_GATE("AND Gate", () -> NodeRegistry.addGate(new AndGate())),
    OR_GATE("OR Gate", () -> NodeRegistry.addGate(new OrGate())),
    NAND_GATE("NAND Gate", () -> NodeRegistry.addGate(new NandGate())),
    NOR_GATE("NOR Gate", () -> NodeRegistry.addGate(new NorGate())),
    XOR_GATE("XOR Gate", () -> NodeRegistry.addGate(new XorGate())),
    XNOR_GATE("XNOR Gate", () -> NodeRegistry.addGate(new XNorGate())),
    NOT_GATE("NOT Gate", () -> NodeRegistry.addGate(new InverterGate())),
    SPLITTER_GATE("Splitter Gate", () -> NodeRegistry.addGate(new SplitterGate())),
    INPUT("INPUT", () -> NodeRegistry.addInput(new DefaultInput())),
    OUTPUT("OUTPUT", () -> NodeRegistry.addOutput(new DefaultOutput()));


    private final String itemName;
    private final Runnable addAction;

    NodeMap(String itemName, Runnable addAction) {
        this.itemName = itemName;
        this.addAction = addAction;
    }

    /**
     * Get the node mapping by its item name.
     *
     * @param name combo box item name
     * @return node mapping
     * @throws IllegalArgumentException if the name doesn't match a mapping (should never happen)
     */
    public static NodeMap getByName(String name) {
        for (NodeMap value : values()) {
            if (value.getItemName().equals(name)) {
                return value;
            }
        }

        throw new IllegalArgumentException(String.format("%s cannot be matched as Node", name));
    }

    /**
     * Get the item name.
     * The name is used to list the nodes in the combobox.
     *
     * @return item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Run the add action, so the {@link NodeRegistry} adds the node.
     */
    public void run() {
        addAction.run();
    }
}