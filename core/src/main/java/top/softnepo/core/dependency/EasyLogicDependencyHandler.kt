package top.softnepo.core.dependency

import top.softnepo.core.EasyLogicContext

internal interface EasyLogicDependencyHandler<T> : EasyLogicContext {
    fun implementation(reference: T)
    fun testImplementation(reference: T)
    fun kapt(reference: T)
    fun kaptAndroidTest(reference: T)
    fun androidTestImplementation(reference: T)

    fun importImplementation(reference: T)
    fun importTestImplementation(reference: T)
    fun importAndroidTestImplementation(reference: T)
}