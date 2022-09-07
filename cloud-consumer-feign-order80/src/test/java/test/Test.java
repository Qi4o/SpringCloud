package test;

import javax.annotation.Resource;

/**
 * @Author Qiao
 * @Create 2022/8/10 16:26
 */

public class Test {


    @Resource
    static TestInterface test;

    public static void main(String[] args) {

        test.add();
    }
}
