package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置类与bean.xml作用相同
 *
 * Configuration
 *      作用：指定配置类
 *
 * ComponentScan("dao")
 *      作用：指定扫描包相当于<context:component-scan base-package="dao"></context:component-scan>
 *      属性：value
 *
 * Import
 *      作用：导入其它配置类
 *      属性：
 *          value：配置类的class属性
 *
 *  PropertySource("")
 *      作用：指定.properties文件路径
 *      属性：
 *            vlaue：文件路径
 *            关键字：classpath,表示类路径下
 *
 */


@ComponentScan({"dao","service"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfig {




}
