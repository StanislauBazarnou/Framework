package framework.model;

import java.util.Objects;

public class CalculatorForm {
    private final int numberOfInstances;
    private final String operatingSystem;
    private final String machineClass;
    private final String machineType;
    private final int numberOfGpus;
    private final String gpuType;
    private final String localSsd;
    private final String datacenterLocation;
    private final String committedUsage;
    private final String totalEstimatedCost;

    public CalculatorForm(int numberOfInstances, String operatingSystem, String machineClass, String machineType,
                          int numberOfGpus, String gpuType, String localSsd, String datacenterLocation,
                          String committedUsage, String totalEstimatedCost) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineType = machineType;
        this.numberOfGpus = numberOfGpus;
        this.gpuType = gpuType;
        this.localSsd = localSsd;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
        this.totalEstimatedCost = totalEstimatedCost;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getMachineType() {
        return machineType;
    }

    public int getNumberOfGpus() {
        return numberOfGpus;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public String getTotalEstimatedCost() {
        return totalEstimatedCost;
    }

    @Override
    public String toString() {
        return "CalculatorForm{" +
                "numberOfInstances=" + numberOfInstances +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGpus=" + numberOfGpus +
                ", gpuType='" + gpuType + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                ", totalEstimatedCost='" + totalEstimatedCost + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorForm that = (CalculatorForm) o;
        return numberOfInstances == that.numberOfInstances &&
                numberOfGpus == that.numberOfGpus &&
                Objects.equals(operatingSystem, that.operatingSystem) &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(localSsd, that.localSsd) &&
                Objects.equals(datacenterLocation, that.datacenterLocation) &&
                Objects.equals(committedUsage, that.committedUsage) &&
                Objects.equals(totalEstimatedCost, that.totalEstimatedCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystem, machineClass, machineType, numberOfGpus, gpuType, localSsd, datacenterLocation, committedUsage, totalEstimatedCost);
    }
}
