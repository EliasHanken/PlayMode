package me.streafe.PlayMode.games;

public class Entry<KeyType, ValueType> {

    private final KeyType key;
    private final ValueType valueType;

    public Entry(KeyType key, ValueType valueType) {
        this.key = key;
        this.valueType = valueType;
    }

    public KeyType getKey() {
        return key;
    }

    public ValueType getValueType() {
        return valueType;
    }
}
