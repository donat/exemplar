/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.exemplar;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.exemplar.tasks.DiscoverSamples;

public class ExemplarPlugin implements Plugin<Project> {
    public static final String EXTENSION_NAME = "exemplar";
    public static final String DISCOVER_SAMPLES_TASK_NAME = "discoverSamples";

    @Override
    public void apply(Project project) {
        ExemplarPluginExtension exemplarPluginExtension = project.getExtensions().create(EXTENSION_NAME, ExemplarPluginExtension.class, project);
        exemplarPluginExtension.getOutputDir().set(project.getLayout().getBuildDirectory().dir("exemplar"));
        exemplarPluginExtension.getInputDir().set(project.getLayout().getProjectDirectory().dir("src/docs"));

        // TODO: Get declared Gradle version compatibility from a standard location (TBD where)

        DiscoverSamples discoverSamplesTask = project.getTasks().create(DISCOVER_SAMPLES_TASK_NAME, DiscoverSamples.class);
        discoverSamplesTask.setGroup(JavaBasePlugin.VERIFICATION_GROUP);
        discoverSamplesTask.setDescription("Generates a JSON file containing all discovered samples and their options");

//        Some convention plugin on top of Exemplar
//        Capability: Allow users to declare which versions of Gradle to test
//        Run min and max versions only
//        Discovery, Execute, and Report
        // TODO: integrate with java-gradle-plugin
    }
}
