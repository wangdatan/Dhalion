/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 *
 * This program is made available under the terms of the MIT License.
 * See the LICENSE file in the project root for more information.
 */
package com.microsoft.dhalion.api;

import java.util.List;

import com.microsoft.dhalion.resolver.Action;
import com.microsoft.dhalion.symptom.Diagnosis;

/**
 * A {@link IResolver}'s major goal is to resolve the anomaly identified by a {@link Diagnosis}.
 * Input to a {@link IResolver} is a {@link Diagnosis} instance and based on that, it executes
 * appropriate action to bring a linked component or system back to a healthy state.
 */
public interface IResolver extends AutoCloseable {
  /**
   * This method is invoked once to initialize the {@link IResolver} instance
   */
  default void initialize() {
  }

  /**
   * {@link IResolver#resolve} is invoked to fix one or more problems identified in the
   * {@link Diagnosis} instance.
   *
   * @param diagnosis the anomaly detected by a detector
   * @return all the actions executed by this resolver to mitigate the problems
   */
  default List<Action> resolve(Diagnosis diagnosis){
    return null;
  }

  /**
   * Release all acquired resources and prepare for termination of this instance
   */
  default void close() {
  }
}
