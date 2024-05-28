package br.unisanta.mvvmlogin.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import br.unisanta.mvvmlogin.R
import br.unisanta.mvvmlogin.database.AppDatabase
import br.unisanta.mvvmlogin.databinding.ActivityLoginBinding
import br.unisanta.mvvmlogin.model.User
import br.unisanta.mvvmlogin.model.Product
import br.unisanta.mvvmlogin.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    val viewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "databaseUnisanta"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        val userDao = db.userDao()
        val productDao = db.productDao()

        binding.btnCadastrar.setOnClickListener {
            val conteudoUser = binding.edtUserName.text.toString()
            val conteudoPass = binding.edtPassword.text.toString()
            val usuario = User(0, conteudoUser, conteudoPass)
            userDao.insertUser(usuario)
            Toast.makeText(this, "$conteudoUser , $conteudoPass", Toast.LENGTH_SHORT).show()
            val usuarios: List<User> = userDao.getAllUsers()
            usuarios.forEach { user ->
                Log.i("TAG", "OnClickCadastrar: ${user.user_name} | ${user.password} ")
            }
        }

        binding.btnLogar.setOnClickListener {
            val conteudoUser = binding.edtUserName.text.toString()
            val conteudoPass = binding.edtPassword.text.toString()
            val user: User? = userDao.checkLogin(conteudoUser, conteudoPass)
            if (user != null) {
                Toast.makeText(this, "Login Realizado Com Sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login ou senha não encontrados!", Toast.LENGTH_SHORT).show()
            }
            Log.i("BtnLogar", "$conteudoUser,$conteudoPass ")
        }

        // Exemplo de inserção e recuperação de produtos
        val product = Product(0, "Example Product", 19.99)
        productDao.insertProduct(product)
        val products: List<Product> = productDao.getAllProducts()
        products.forEach { prod ->
            Log.i("TAG", "Product: ${prod.product_name} | ${prod.product_price}")
        }
    }
}
