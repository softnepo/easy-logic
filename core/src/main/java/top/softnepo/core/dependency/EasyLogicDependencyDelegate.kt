package top.softnepo.core.dependency

import org.gradle.kotlin.dsl.DependencyHandlerScope
import top.softnepo.internal.EasyLogicContext.Companion.DEPENDENCY_ANDROID_TEST_IMPLEMENTATION
import top.softnepo.internal.EasyLogicContext.Companion.DEPENDENCY_IMPLEMENTATION
import top.softnepo.internal.EasyLogicContext.Companion.DEPENDENCY_KAPT
import top.softnepo.internal.EasyLogicContext.Companion.DEPENDENCY_KAPT_ANDROID_TEST
import top.softnepo.internal.EasyLogicContext.Companion.DEPENDENCY_TEST_IMPLEMENTATION
import org.gradle.kotlin.dsl.project

abstract class EasyLogicDependencyDelegate : EasyLogicDependencyHandler<Any> {

    abstract val handlerScope: DependencyHandlerScope
    override fun implementation(reference: Any) {
        handlerScope.add(DEPENDENCY_IMPLEMENTATION, reference)
    }

    override fun testImplementation(reference: Any) {
        handlerScope.add(DEPENDENCY_TEST_IMPLEMENTATION, reference)
    }

    override fun kapt(reference: Any) {
        handlerScope.add(DEPENDENCY_KAPT, reference)
    }

    override fun kaptAndroidTest(reference: Any) {
        handlerScope.add(DEPENDENCY_KAPT_ANDROID_TEST, reference)
    }

    override fun androidTestImplementation(reference: Any) {
        handlerScope.add(DEPENDENCY_ANDROID_TEST_IMPLEMENTATION, reference)
    }

    override fun importImplementation(reference: Any) {
       implementation(handlerScope.project(reference as String))
    }

    override fun importTestImplementation(reference: Any) {
        testImplementation(handlerScope.project(reference as String))
    }

    override fun importAndroidTestImplementation(reference: Any) {
        androidTestImplementation(handlerScope.project(reference as String))
    }
}