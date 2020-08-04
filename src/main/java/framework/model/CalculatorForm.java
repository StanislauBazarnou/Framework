package framework.model;

import java.util.Objects;

public class CalculatorForm {
    private final String numberOfInstances;
    private final String operatingSystemDropdown;
    private final String operatingSystem;
    private final String machineClassDropdown;
    private final String machineClass;
    private final String machineTypeDropdown;
    private final String machineType;
    private final String numberOfGpusDropdown;
    private final String numberOfGpus;
    private final String gpuTypeDropdown;
    private final String gpuType;
    private final String localSsdDropdown;
    private final String localSsd;
    private final String datacenterLocationDropdown;
    private final String datacenterLocation;
    private final String committedUsageDropdown;
    private final String committedUsage;
    private final String totalEstimatedCost;


//    public CalculatorForm(int numberOfInstances, String operatingSystem, String machineClass, String machineType,
//                          int numberOfGpus, String gpuType, String localSsd, String datacenterLocation,
//                          String committedUsage, String totalEstimatedCost) {
//        this.numberOfInstances = numberOfInstances;
//        this.operatingSystem = operatingSystem;
//        this.machineClass = machineClass;
//        this.machineType = machineType;
//        this.numberOfGpus = numberOfGpus;
//        this.gpuType = gpuType;
//        this.localSsd = localSsd;
//        this.datacenterLocation = datacenterLocation;
//        this.committedUsage = committedUsage;
//        this.totalEstimatedCost = totalEstimatedCost;
//    }

    public CalculatorForm(String numberOfInstances, String operatingSystemDropdown, String operatingSystem,
                          String machineClassDropdown, String machineClass, String machineTypeDropdown,
                          String machineType, String numberOfGpusDropdown, String numberOfGpus, String gpuTypeDropdown, String gpuType,
                          String localSsdDropdown, String localSsd, String datacenterLocationDropdown,
                          String datacenterLocation, String committedUsageDropdown, String committedUsage,
                          String totalEstimatedCost) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystemDropdown = operatingSystemDropdown;
        this.operatingSystem = operatingSystem;
        this.machineClassDropdown = machineClassDropdown;
        this.machineClass = machineClass;
        this.machineTypeDropdown = machineTypeDropdown;
        this.machineType = machineType;
        this.numberOfGpusDropdown = numberOfGpusDropdown;
        this.numberOfGpus = numberOfGpus;
        this.gpuTypeDropdown = gpuTypeDropdown;
        this.gpuType = gpuType;
        this.localSsdDropdown = localSsdDropdown;
        this.localSsd = localSsd;
        this.datacenterLocationDropdown = datacenterLocationDropdown;
        this.datacenterLocation = datacenterLocation;
        this.committedUsageDropdown = committedUsageDropdown;
        this.committedUsage = committedUsage;
        this.totalEstimatedCost = totalEstimatedCost;
    }

    public String getNumberOfGpusDropdown() {
        return numberOfGpusDropdown;
    }

    public String getNumberOfInstances() {
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

    public String getNumberOfGpus() {
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

    public String getOperatingSystemDropdown() {
        return operatingSystemDropdown;
    }

    public String getMachineClassDropdown() {
        return machineClassDropdown;
    }

    public String getMachineTypeDropdown() {
        return machineTypeDropdown;
    }

    public String getGpuTypeDropdown() {
        return gpuTypeDropdown;
    }

    public String getLocalSsdDropdown() {
        return localSsdDropdown;
    }

    public String getDatacenterLocationDropdown() {
        return datacenterLocationDropdown;
    }

    public String getCommittedUsageDropdown() {
        return committedUsageDropdown;
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
