/**
 * @author Hinsteny
 * @version module-info: module-info 2019-05-09 16:05 All rights reserved.$
 */
module org.hisoka.commons.core {

    requires java.desktop;
    requires org.apache.logging.log4j;

    exports org.hisoka.commons.core.base;
    exports org.hisoka.commons.core.functional.page;
    exports org.hisoka.commons.core.io.csv;
    exports org.hisoka.commons.core.io.image;
    exports org.hisoka.commons.core.utils;

}