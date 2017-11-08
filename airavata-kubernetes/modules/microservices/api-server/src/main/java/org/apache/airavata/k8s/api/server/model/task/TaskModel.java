/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.airavata.k8s.api.server.model.task;

import org.apache.airavata.k8s.api.server.model.commons.ErrorModel;
import org.apache.airavata.k8s.api.server.model.job.JobModel;
import org.apache.airavata.k8s.api.server.model.process.ProcessModel;
import org.apache.airavata.k8s.api.server.model.task.type.TaskModelType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Class level comments please
 *
 * @author dimuthu
 * @since 1.0.0-SNAPSHOT
 */
@Entity
@Table(name = "TASK_MODEL")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private TaskModelType taskType;

    @ManyToOne
    private ProcessModel parentProcess;

    private long creationTime;
    private long lastUpdateTime;
    private int orderIndex;

    private boolean startingTask;

    private boolean stoppingTask;

    @OneToMany(mappedBy = "taskModel", cascade = CascadeType.ALL)
    private List<TaskStatus> taskStatuses = new ArrayList<>();

    private String taskDetail;

    @OneToMany(mappedBy = "taskModel", cascade = CascadeType.ALL)
    private List<ErrorModel> taskErrors = new ArrayList<>();

    @OneToMany(mappedBy = "taskModel", cascade = CascadeType.ALL)
    private List<JobModel> jobs = new ArrayList<>();

    @OneToMany(mappedBy = "taskModel", cascade = CascadeType.ALL)
    private List<TaskInput> taskInputs = new ArrayList<>();

    @OneToMany(mappedBy = "taskModel", cascade = CascadeType.ALL)
    private List<TaskOutput> taskOutputs = new ArrayList<>();

    @OneToMany(mappedBy = "taskModel", cascade = CascadeType.ALL)
    private List<TaskOutPort> taskOutPorts = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProcessModel getParentProcess() {
        return parentProcess;
    }

    public void setParentProcess(ProcessModel parentProcess) {
        this.parentProcess = parentProcess;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<TaskStatus> getTaskStatuses() {
        return taskStatuses;
    }

    public void setTaskStatuses(List<TaskStatus> taskStatuses) {
        this.taskStatuses = taskStatuses;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    public List<ErrorModel> getTaskErrors() {
        return taskErrors;
    }

    public void setTaskErrors(List<ErrorModel> taskErrors) {
        this.taskErrors = taskErrors;
    }

    public List<JobModel> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobModel> jobs) {
        this.jobs = jobs;
    }

    public List<TaskInput> getTaskInputs() {
        return taskInputs;
    }

    public TaskModel setTaskInputs(List<TaskInput> taskInputs) {
        this.taskInputs = taskInputs;
        return this;
    }

    public List<TaskOutput> getTaskOutputs() {
        return taskOutputs;
    }

    public TaskModel setTaskOutputs(List<TaskOutput> taskOutputs) {
        this.taskOutputs = taskOutputs;
        return this;
    }

    public TaskModelType getTaskType() {
        return taskType;
    }

    public TaskModel setTaskType(TaskModelType taskType) {
        this.taskType = taskType;
        return this;
    }

    public boolean isStartingTask() {
        return startingTask;
    }

    public TaskModel setStartingTask(boolean startingTask) {
        this.startingTask = startingTask;
        return this;
    }

    public boolean isStoppingTask() {
        return stoppingTask;
    }

    public TaskModel setStoppingTask(boolean stoppingTask) {
        this.stoppingTask = stoppingTask;
        return this;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public TaskModel setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskOutPort> getTaskOutPorts() {
        return taskOutPorts;
    }

    public void setTaskOutPorts(List<TaskOutPort> taskOutPorts) {
        this.taskOutPorts = taskOutPorts;
    }
}
