//package org.coder.lab0201springauthorizationserver;
//
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
///**
// * @Description
// * @Author dongnan
// * @CreateTime 2024/10/12  09:37
// */
//public class CodeGeneratorTest {
//
//    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/miller?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true", "root", "123456");
//
//    public static void main(String[] args) {
//        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
//                // 全局配置
//                .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称？")).fileOverride())
//                // 包配置
//                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))
//                // 策略配置
//                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
//                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
//                        .entityBuilder().enableLombok()
////                        .addTableFills(
////                                new Column("create_time", FieldFill.INSERT)
////                        )
//                        .build())
//                /*
//                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
//                   .templateEngine(new BeetlTemplateEngine())
//                   .templateEngine(new FreemarkerTemplateEngine())
//                 */
//                .execute();
//    }
//
//    protected static List<String> getTables(String tables) {
//        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
//    }
//}
