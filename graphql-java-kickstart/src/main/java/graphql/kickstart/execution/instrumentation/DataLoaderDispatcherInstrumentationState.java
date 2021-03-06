package graphql.kickstart.execution.instrumentation;

import graphql.execution.ExecutionId;
import graphql.execution.instrumentation.InstrumentationState;
import org.dataloader.DataLoaderRegistry;

/** A base class that keeps track of whether aggressive batching can be used */
public class DataLoaderDispatcherInstrumentationState implements InstrumentationState {

  private final TrackingApproach approach;
  private final DataLoaderRegistry dataLoaderRegistry;
  private final boolean hasNoDataLoaders;
  private boolean aggressivelyBatching = true;

  public DataLoaderDispatcherInstrumentationState(
      DataLoaderRegistry dataLoaderRegistry, TrackingApproach approach, ExecutionId executionId) {

    this.dataLoaderRegistry = dataLoaderRegistry;
    this.approach = approach;
    approach.createState(executionId);
    hasNoDataLoaders = dataLoaderRegistry.getKeys().isEmpty();
  }

  boolean isAggressivelyBatching() {
    return aggressivelyBatching;
  }

  void setAggressivelyBatching(boolean aggressivelyBatching) {
    this.aggressivelyBatching = aggressivelyBatching;
  }

  TrackingApproach getApproach() {
    return approach;
  }

  DataLoaderRegistry getDataLoaderRegistry() {
    return dataLoaderRegistry;
  }

  boolean hasNoDataLoaders() {
    return hasNoDataLoaders;
  }
}
