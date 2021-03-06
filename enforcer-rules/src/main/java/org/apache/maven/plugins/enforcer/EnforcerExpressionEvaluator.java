package org.apache.maven.plugins.enforcer;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.MojoExecution;
import org.apache.maven.plugin.PluginParameterExpressionEvaluator;
import org.apache.maven.plugin.descriptor.MojoDescriptor;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.path.PathTranslator;

/**
 * The Class EnforcerExpressionEvaluator. This class wraps the PluginParameterExpressionEvaluator because it can't be
 * accessed directly in 2.0.x so we must create a new one.
 *
 * @author <a href="mailto:brianf@apache.org">Brian Fox</a>
 */
public class EnforcerExpressionEvaluator
    extends PluginParameterExpressionEvaluator
{

    /**
     * The Constructor.
     *
     * @param theContext {@link MavenSession}
     * @param thePathTranslator {@link PathTranslator}
     * @param theProject {@link MavenProject}
     * @param theExecution {@link MojoExecution}
     */
    public EnforcerExpressionEvaluator( MavenSession theContext, PathTranslator thePathTranslator,
                                        MavenProject theProject, MojoExecution theExecution )
    {
        super( theContext, theExecution, thePathTranslator, null, theProject, theContext.getExecutionProperties() );
    }

    /**
     * This constructor is kept for backward compatibility.
     * 
     * @param theContext {@link MavenSession}
     * @param thePathTranslator {@link PathTranslator}
     * @param theProject {@link MavenProject}
     * 
     * @deprecated Will be removed with 2.0
     */
    public EnforcerExpressionEvaluator( MavenSession theContext, PathTranslator thePathTranslator,
                                        MavenProject theProject )
    {
        super( theContext, new MojoExecution( new MojoDescriptor() ), thePathTranslator, null, theProject,
               theContext.getExecutionProperties() );
    }
}
