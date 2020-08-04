package framework.service;

import framework.model.CalculatorForm;
import static framework.service.TestDataReader.getTestData;

public class CalculatorFormCreator {
    public static final String NUMBER_OF_INSTANCES = "calculator.number.of.instances";
    public static final String OPERATING_SYSTEM_DROPDOWN = "calculator.operating.system.dropdown";
    public static final String OPERATING_SYSTEM = "calculator.operating.system";

    public static final String MACHINE_CLASS_DROPDOWN = "calculator.machine.class.dropdown";
    public static final String MACHINE_CLASS = "calculator.machine.class";

    public static final String MACHINE_TYPE_DROPDOWN = "calculator.machine.type.dropdown";
    public static final String MACHINE_TYPE = "calculator.machine.type";

    public static final String NUMBER_OF_GPUS_DROPDOWN = "calculator.number.of.gpus.dropdown";
    public static final String NUMBER_OF_GPUS = "calculator.number.of.gpus";

    public static final String GPU_TYPE_DROPDOWN = "calculator.gpu.type.dropdown";
    public static final String GPU_TYPE = "calculator.gpu.type";

    public static final String LOCAL_SSD_DROPDOWN = "calculator.local.ssd.dropdown";
    public static final String LOCAL_SSD = "calculator.local.ssd";

    public static final String DATACENTER_LOCATION_DROPDOWN = "calculator.datacenter.location.dropdown";
    public static final String DATACENTER_LOCATION = "calculator.datacenter.location";

    public static final String COMMITTED_USAGE_DROPDOWN = "calculator.committed.usage.dropdown";
    public static final String COMMITTED_USAGE = "calculator.committed.usage";

    public static final String TOTAL_ESTIMATED_COST = "calculator.estimate.total.cost";


    public static CalculatorForm withDataFromProperty(){
        return new CalculatorForm(
                getTestData(NUMBER_OF_INSTANCES),
                getTestData(OPERATING_SYSTEM_DROPDOWN),
                getTestData(OPERATING_SYSTEM),
                getTestData(MACHINE_CLASS_DROPDOWN),
                getTestData(MACHINE_CLASS),
                getTestData(MACHINE_TYPE_DROPDOWN),
                getTestData(MACHINE_TYPE),
                getTestData(NUMBER_OF_GPUS_DROPDOWN),
                getTestData(NUMBER_OF_GPUS),
                getTestData(GPU_TYPE_DROPDOWN),
                getTestData(GPU_TYPE),
                getTestData(LOCAL_SSD_DROPDOWN),
                getTestData(LOCAL_SSD),
                getTestData(DATACENTER_LOCATION_DROPDOWN),
                getTestData(DATACENTER_LOCATION),
                getTestData(COMMITTED_USAGE_DROPDOWN),
                getTestData(COMMITTED_USAGE),
                getTestData(TOTAL_ESTIMATED_COST));
    }
}
