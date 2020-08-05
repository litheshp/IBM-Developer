/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jstevenperry.intro.streamsapi;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class Manager extends Employee implements StockOptionEligible, BonusEligible {

    /**
     * 
     */
    private static final long serialVersionUID = 8899812821932390993L;

    private static final Logger log = Logger.getLogger(Manager.class.getName());

    public Manager() {
        super();
    }

    public Manager(String name, int age, int height, int weight, String eyeColor, Gender gender,
            String taxpayerIdNumber, String employeeNumber, BigDecimal salary) {
        super(name, age, height, weight, eyeColor, gender, taxpayerIdNumber, employeeNumber, salary);
    }

    public Manager(String name, int age, int height, int weight, String eyeColor, Gender gender) {
        super(name, age, height, weight, eyeColor, gender);
    }
    
    public static Manager promote(final Employee employee) {
        Manager manager = new Manager(employee.getName(), employee.getAge(), employee.getHeight(),
                employee.getWeight(), employee.getEyeColor(), employee.getGender(),
                employee.getTaxpayerIdNumber(), employee.getEmployeeNumber(), 
                employee.getSalary().multiply(BigDecimal.valueOf(1.2)).setScale(2)); // And a 20% raise!
        return manager;
    }
    
    @Override
    public void processStockOptions(int numberOfOptions, BigDecimal price) {
        log.info("Wow, I, " + getName() + ", can't believe I got " + numberOfOptions + " options at $" + price.toPlainString() + "each!");
    }

}
