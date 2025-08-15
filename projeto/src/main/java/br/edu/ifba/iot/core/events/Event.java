package br.edu.ifba.iot.core.events;

public record Event(EventType type, String sourceId, double value, String payload) { }