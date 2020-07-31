package framework.service;

import by.epam.learn.framework.model.CalculatorForm;

import static by.epam.learn.framework.service.TestDataReader.getTestData;

public class CalculatorFormCreator {
    public static final String NUMBER_OF_INSTANCES = "calculator.number.of.instances";
    public static final String OPERATING_SYSTEM = "calculator.operating.system";
    public static final String MACHINE_CLASS = "calculator.machine.class";
    public static final String MACHINE_TYPE = "calculator.machine.type";
    public static final String NUMBER_OF_GPUS = "calculator.number.of.gpus";
    public static final String GPU_TYPE = "calculator.gpu.type";
    public static final String LOCAL_SSD = "calculator.local.ssd";
    public static final String DATACENTER_LOCATION = "calculator.datacenter.location";
    public static final String COMMITTED_USAGE = "calculator.committed.usage";
    public static final String TOTAL_ESTIMATED_COST = "calculator.estimate.total.cost";

    public static CalculatorForm withDataFromProperty(){
        return new CalculatorForm(
                Integer.parseInt(getTestData(NUMBER_OF_INSTANCES)),
                getTestData(OPERATING_SYSTEM),
                getTestData(MACHINE_CLASS),
                getTestData(MACHINE_TYPE),
                Integer.parseInt(getTestData(NUMBER_OF_GPUS)),
                getTestData(GPU_TYPE),
                getTestData(LOCAL_SSD),
                getTestData(DATACENTER_LOCATION),
                getTestData(COMMITTED_USAGE),
                getTestData(TOTAL_ESTIMATED_COST));
    }
}
